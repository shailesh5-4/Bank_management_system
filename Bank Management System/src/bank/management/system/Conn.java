package bank.management.system;

import java.sql.*;
//here we will connect the database using jdbc which consists of five steps
public class Conn {
    //mysql is an external entity so chances of error, so we will do exceptional handling
    Connection c;
    Statement s;
public Conn(){    
     try{
  //  Class.forName(com.mysql.cj.jdbc.Driver); //no need to register driver ,java does it by itself
    c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","7860369206");
    s = c.createStatement();
     }catch(Exception e)
            {
                System.out.println(e);
            }
}
}
