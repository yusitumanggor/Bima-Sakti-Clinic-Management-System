

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static Connection connection;
    
    public static Connection createConnection() throws SQLException {
        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection to the database
                String url = "jdbc:mysql://localhost:3306/final_se";
                String username = "root";
                String password = "";
                connection = DriverManager.getConnection(url, username, password);

            } catch (ClassNotFoundException ex) {
                System.out.println("Could not load JDBC driver: " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Error executing SQL query: " + ex.getMessage());
                throw ex; // Rethrow the exception
            }
        }
        return connection;
    }
    
    public static void main(String args[]) {
        try {
            Connection conn = createConnection();
            if (conn != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed!");
            }
        } catch (SQLException ex) {
            System.out.println("Error establishing connection: " + ex.getMessage());
        }
    }

    static Connection configDB() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
