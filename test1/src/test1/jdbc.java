package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jdbc
{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public jdbc() throws Exception
    {
        
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sudheer","root","");
        ps=con.prepareStatement("insert into Calculations values('abc',2.90)");
        ps.executeUpdate();
        ps=con.prepareStatement("select * from Calculations");
        rs=ps.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getString(1));
            System.out.println(rs.getInt(2));
        }
        con.close();
    }
  public static void main(String args[]) throws Exception
  {
      jdbc j=new jdbc();
  }
} 
  