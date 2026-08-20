package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class dbConnection {
    Connection connection;
    public dbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_penjualan",
                "root",
                ""
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
}
