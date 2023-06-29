/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class connectlogin {
    private static java.sql.Connection koneksi;
    
    public static java.sql.Connection getconnectlogin() {
        if (koneksi == null){
            try{
		String url= "jdbc:mysql://localhost:3306/final_se";
		String user= "root";
		String password= "";
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Succesfully");
            }catch (SQLException e){
		System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
	return koneksi;
    }
    public static void main(String args[]){
            getconnectlogin();
    }
}
