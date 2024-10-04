package airlinemanagementsystem2;

import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem2", "root", "aditya");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
