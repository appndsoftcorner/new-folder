/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;
import java.io.*;
import java.util.*;
import java.io.IOException;
 
public class test1 
{
public static void main(String[] args) throws IOException
{
PrintWriter pw;
int i=0;
String[] token;
try 
{
String content = new Scanner(new File("C:/Users/phantom/Desktop/project/cv000_29590.txt")).useDelimiter("\\Z").next();
StringTokenizer st = new StringTokenizer(content, " \t\n\r\f,.:;?![]<>()-/\"");
pw=new PrintWriter("final.txt");

token=new String[content.length()];
while(st.hasMoreTokens())
{
token[i]=(String)st.nextToken();
i++;
}
for(int j=0;j<i;j++)
{
System.out.println(token[j]);
pw.println(token[j]);
}
if(pw!=null)
pw.close();
}
catch(IOException ioe)
{
    ioe.printStackTrace();
}
catch(Exception e)
{}
finally{
       }



}}

