package sanjeevani.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    
    private static Connection conn;
    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded before");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "abcd");
            System.out.println("Connection opened!");
        }
        catch(ClassNotFoundException | SQLException e)
        {
           JOptionPane.showMessageDialog(null,"DB Error in opening connection in DBconnection","Error!",JOptionPane.ERROR_MESSAGE);
        }  
    }
    public static Connection getConnection()
    {
        return conn;
        
    }
    public static void  closeConnection()
    {
        try
        {
            conn.close();
            System.out.println("Connection close!");
        }
        catch(SQLException s)
            {
                JOptionPane.showMessageDialog(null,"some problem in DataBase","Error!",JOptionPane.ERROR_MESSAGE);
                        s.getStackTrace();
            }
    }
}
