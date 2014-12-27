package test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
public class BucketOfWords 
{
 @SuppressWarnings("unchecked")
 public static void main(String[] args) 
 {
 BufferedWriter bw;
 String[] buffer;
 int k=0;
     try
     {
  String text = new Scanner(new File("C:/Users/phantom/Desktop/project/merged dataset/mergefile.txt")).useDelimiter("\\Z").next();
  bw=new BufferedWriter(new FileWriter("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt"));
  List<String> temp = Arrays.asList(text.split("\n"));
  Set<String> uniqueWords = new HashSet<String>(temp);
  buffer=new String[uniqueWords.size()];
  for (String word : uniqueWords) 
  {
   //System.out.println(word);
   //System.out.println(": " + Collections.frequency(temp, word));
   buffer[k]=word;
   k++;
   }
  for(int i=0;i<buffer.length;i++)
  {
      bw.write(buffer[i]);
      bw.newLine();
      System.out.println(buffer[i]);
  }
  bw.close();
   }
    catch(Exception e)
     {
         
     }
    }
}