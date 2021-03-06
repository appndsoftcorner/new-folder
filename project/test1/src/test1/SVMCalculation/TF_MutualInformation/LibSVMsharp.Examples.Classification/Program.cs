﻿using LibSVMsharp.Helpers;
using LibSVMsharp.Extensions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibSVMsharp.Examples.Classification
{
    class Program
    {
        static void Main(string[] args)
        {
            // Load the datasets: In this example I use the same datasets for training and testing which is not suggested
            SVMProblem trainingSet = SVMProblemHelper.Load(@"C:\Users\phantom\Desktop\project\calculations\variants\TF_MutualInformation.txt");
            SVMProblem testSet = SVMProblemHelper.Load(@"C:\Users\phantom\Desktop\project\calculations\variants\TF_MutualInformation.txt");

            // Normalize the datasets if you want: L2 Norm => x / ||x||
            trainingSet = trainingSet.Normalize(SVMNormType.L2);
            testSet = testSet.Normalize(SVMNormType.L2);

            // Select the parameter set
            SVMParameter parameter = new SVMParameter();
            parameter.Type = SVMType.C_SVC;
            parameter.Kernel = SVMKernelType.LINEAR;
            parameter.C = 16.0;
            parameter.Gamma = 0.0078125;

            // Do cross validation to check this parameter set is correct for the dataset or not
            double[] crossValidationResults; // output labels
            int nFold = 5;
            trainingSet.CrossValidation(parameter, nFold, out crossValidationResults);

            // Evaluate the cross validation result
            // If it is not good enough, select the parameter set again
            double crossValidationAccuracy = trainingSet.EvaluateClassificationProblem(crossValidationResults);

            // Train the model, If your parameter set gives good result on cross validation
            SVMModel model = trainingSet.Train(parameter);

            // Save the model
            SVM.SaveModel(model, @"C:\Users\phantom\Desktop\project\calculations\variants\TF_MutualInformation_model.txt");

            // Predict the instances in the test set
            double[] testResults = testSet.Predict(model);

            // Evaluate the test results
            int[,] confusionMatrix;
            double testAccuracy = testSet.EvaluateClassificationProblem(testResults, model.Labels, out confusionMatrix);

            // Print the resutls
            Console.WriteLine("\n\nCross validation accuracy: " + crossValidationAccuracy);
            Console.WriteLine("\nTest accuracy: " + testAccuracy);
            Console.WriteLine("\nConfusion matrix:\n");

            // Print formatted confusion matrix
            Console.Write(String.Format("{0,6}", ""));
            for (int i = 0; i < model.Labels.Length; i++)
                Console.Write(String.Format("{0,5}", "(" + model.Labels[i] + ")"));
            Console.WriteLine();
            for (int i = 0; i < confusionMatrix.GetLength(0); i++)
            {
                Console.Write(String.Format("{0,5}", "(" + model.Labels[i] + ")"));
                for (int j = 0; j < confusionMatrix.GetLength(1); j++)
                    Console.Write(String.Format("{0,5}", confusionMatrix[i,j]));
                Console.WriteLine();
            }

            float precision = confusionMatrix[0, 0] / (confusionMatrix[0, 0] + confusionMatrix[0, 1]);
            float recall = confusionMatrix[0, 0] / (confusionMatrix[0, 0] + confusionMatrix[1, 0]);
            float flScore = (2 * precision * recall) / (precision + recall);
            float accuracy = (confusionMatrix[0, 0] + confusionMatrix[1, 1]) / (confusionMatrix[0, 0] + confusionMatrix[1, 0] + confusionMatrix[0, 1] + confusionMatrix[1, 1]);

            System.IO.StreamWriter file = new System.IO.StreamWriter(@"C:\Users\phantom\Desktop\project\calculations\performance values\performance values2.txt");
            file.Write(precision + ",");
            file.Write(recall + ",");
            file.Write(flScore + ",");
            file.Write(accuracy + "");

            file.Close();

            Console.WriteLine("\n\nPress any key to quit...");
            Console.ReadLine();
        }
    }
}
