package studentManagementSystem;

import java.sql.*;

public class ConnectionProvider {
	static Connection con;

	public static Connection CreateConnection() throws Exception {
		// Step 1: Load the Driver (Not Neccessary Step in new version of JDBC)
//		Class.forName("com.mysql.jdbc.Driver");

		// Create the Connection
		String user = "root";
		String pass = "chirag";
		String url = "jdbc:mysql://localhost:3306/student_database";

		con = DriverManager.getConnection(url, user, pass);

		return con;
	}
}
