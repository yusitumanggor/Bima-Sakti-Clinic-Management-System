

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static Connection connection;
    
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection to the database
                String url = "jdbc:mysql://localhost:3306/final_se";
                String user = "root";
                String password = "";
                connection = DriverManager.getConnection(url, user, password);

                // Execute SQL queries here...

            } catch (ClassNotFoundException ex) {
                System.out.println("Could not load JDBC driver: " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Error executing SQL query: " + ex.getMessage());
            }
        }
        
        return connection;
    }
    
    public static void main(String args[]) {
        getConnection();
    }
}
