package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class MergingFiles 
{
public static void main(String[] args) 
{
String[] fileList;
File folder = new File("C:/Users/phantom/Desktop/project/stopwords removed dataset");
File[] listOfFiles = folder.listFiles();
fileList=new String[listOfFiles.length];
for (int k = 0; k < listOfFiles.length; k++) 
 {
  if (listOfFiles[k].isFile()) 
  {
   fileList[k]=(String)listOfFiles[k].getName();
   System.out.println("File " + listOfFiles[k].getName());
  } 
 }   
for(int k=0;k<fileList.length;k++)
{
File f1 = new File("C:/Users/phantom/Desktop/project/stopwords removed dataset/stopwordsremovedf" +" " + k + ".txt");
File f2 = new File("C:/Users/phantom/Desktop/project/merged dataset/mergefile.txt");

BufferedWriter out = null;
 try 
 {
 out = new BufferedWriter(new FileWriter(f2, true));
 } 
 catch (IOException e1) 
 {
 e1.printStackTrace();
 }
 System.out.println("merging: " + f1.getName());
 FileInputStream fis;
 try 
 {
 fis = new FileInputStream(f1);
 BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 String aLine;
 while((aLine = in.readLine())!= null) 
 {
 aLine = aLine.trim();  
 out.write(aLine);
 out.newLine();
 //System.out.println(aLine);
 }
 in.close();
 }
 
 catch (IOException e) 
 {
 e.printStackTrace();
 }
 try 
 {
 out.close();
 } 
 catch (IOException ex) 
 {
 Logger.getLogger(MergingFiles.class.getName()).log(Level.SEVERE, null, ex);
 }
 
}

}
}

 
