package test1;
import java.io.*;
import java.util.*;
import java.io.IOException;
 
public class UniqueStopWordsRemoval 
{
    private static String[] spliter;
    private static int[] count;
    
public static void main(String[] args) throws IOException
{
BufferedWriter bw;
String[] fileList;
int counter=0;

File folder = new File("C:/Users/phantom/Desktop/project/stopwords removed dataset1/");
File[] listOfFiles = folder.listFiles();
fileList=new String[listOfFiles.length];
for (int k = 0; k < listOfFiles.length; k++) 
 {
  if (listOfFiles[k].isFile()) 
  {
   fileList[k]=(String)listOfFiles[k].getName();
   //System.out.println("File " + listOfFiles[k].getName());
  } 
   }
try 
{
 for(int k=0;k<fileList.length;k++)
 {
String content = new Scanner(new File("C:/Users/phantom/Desktop/project/stopwords removed dataset1/" + fileList[k])).useDelimiter("\\Z").next();
StringTokenizer st = new StringTokenizer(content, " \t\n\r\f,.:;?![]<>()-/\"");
bw=new BufferedWriter((new FileWriter(new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset1/unique stop words removedf " + k + ".txt"))));
String temp1 = content.replaceAll("[\\n]", " ");
String temp = temp1.replaceAll(",", " ");
 spliter = temp.replaceAll("[.?!:;/_]", "").split(" ");
 count = new int[spliter.length];
 for (int i = 0; i < spliter.length; i++)
 {
   temp = spliter[i];
   for (int j = 0; j < spliter.length; j++) 
   {
    if (temp.equalsIgnoreCase(spliter[j])) 
    {
     count[j]++;
     }
   }
  }
 
 for(int i=0;i<spliter.length;i++)
 {
     bw.write(spliter[i].trim());
     bw.write(",");
     String ml=count[i] + "";
     bw.write(ml.trim());
     bw.newLine();
 }
 
 // paste here
 if(bw!=null)
   bw.close();
  }
  
      }
catch(IOException ioe)
{
    ioe.printStackTrace();
}
catch(Exception e)
{}
}

}

