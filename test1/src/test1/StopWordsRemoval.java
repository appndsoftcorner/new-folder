package test1;

import java.io.*;
import java.util.*;

public class StopWordsRemoval
{
    
public static void main(String[] args)
{
    String fileWords,stopWords;
    String[] temp;
    String[] temp1;
    PrintWriter pw;
           
    try
    {
       fileWords = new Scanner(new File("final.txt")).useDelimiter("\\Z").next();
       //System.out.println(fileWords);
       temp=new String[fileWords.length()];
       temp=fileWords.split("\n");
       stopWords = new Scanner(new File("C:/Users/phantom/Desktop/project/stopwords english.txt")).useDelimiter("\\Z").next();
       temp1=new String[stopWords.length()];
       temp1=stopWords.split("\n");
                     
       for(int i=0;i<temp.length;i++)
        {
           for(String j:temp1)
           {
             if(temp[i].equals(j))
             {
                 temp[i]="abc";
                 continue;
             }
              
           }
       }
                 
       pw=new PrintWriter("stopwordsremovedf.txt");
       
        for (String temp2 : temp) {
            if(temp2!="abc")
            pw.print(temp2);
            }
                   
        pw.close();
         
    
    }
    catch(Exception e)
    {}
     
}

}

