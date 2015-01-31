package test1.printing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TF_MutualInformationMatrix
{
    private BufferedReader br;
    private BufferedWriter bw;
    private int length;
    
    private TF_MutualInformationMatrix()
    {
        br=null;
        bw=null;
        length=15;
    }
    
    public void bucketOfWordsPrinting() throws FileNotFoundException, IOException
    {
       String s;
       String arr1[][];
       int i=0;
       br=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")));
       String content = new Scanner(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")).useDelimiter("\\Z").next();
       arr1=new String[content.length()][2];
       while((s=br.readLine())!=null)
       {
           arr1[i]=s.split(",");
           i++;
       }
       bw=new BufferedWriter(new FileWriter(new File("C:/Users/phantom/Desktop/project/calculations/Matrix Format/MatrixFormat.txt")));
       bw.write("               ");
       for(int j=0;j<arr1.length;j++)
       {
           if(arr1[j][0]!=null)
           {
           System.out.println(arr1[j][0]);
           String s1=arr1[j][0];
           int temp=15-s1.length();
           bw.write(s1);
           for(int k=0;k<temp;k++)
           {
               bw.write(" ");
           }
           bw.write("|");
           
       }
       }bw.close();
    }
    
    public void documentPrinting() throws IOException
    {
File folder = new File("C:/Users/phantom/Desktop/project/input dataset/pos/");
File[] listOfFiles = folder.listFiles();
String[] fileList = new String[listOfFiles.length];
for (int k = 0; k < listOfFiles.length; k++) 
 {
  if (listOfFiles[k].isFile()) 
  {
   fileList[k]=(String)listOfFiles[k].getName();
   //System.out.println("File " + listOfFiles[k].getName());
  } 
   }
File f=new File("C:/Users/phantom/Desktop/project/calculations/Matrix Format/MatrixFormat.txt");
bw=new BufferedWriter(new FileWriter(f,true));
for(int k=0;k<listOfFiles.length;k++)
{
    String s1=fileList[k];
    int temp=15-s1.length();
    bw.write(s1);
    for(int l=0;l<temp;l++)
    {
        bw.write(" ");
    }
    bw.newLine();
    bw.write("---------------");
    bw.write("|");
    bw.newLine();
    
}bw.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        TF_MutualInformationMatrix ob1=new TF_MutualInformationMatrix();
        ob1.bucketOfWordsPrinting();
        ob1.documentPrinting();
        
        
    }

}