package studentManagementSystem;

import java.sql.*;

public class CRUDStudent {

//	Add Student Data
	public static boolean addStudent(Student st) {

		boolean f = false;

		try {
			// Creating Connection
			Connection con = ConnectionProvider.CreateConnection();
			String query = "insert into student(Enrollment_No, Student_Name, Student_Email, Student_Phone, Semester) values(?,?,?,?,?)";

			// Prepared Statement
			PreparedStatement statement = con.prepareStatement(query);

			// Set the Values of Parameters
			statement.setString(1, st.getEnrollmentNumber());
			statement.setString(2, st.getStudentName());
			statement.setString(3, st.getStudentEmail());
			statement.setString(4, st.getStudentPhone());
			statement.setInt(5, st.getSemester());

			// Execute
			int t = statement.executeUpdate();
			System.out.println("\nNumber of rows affected: " + t);
			f = true;
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

//	Delete Student Data 
	public static boolean deleteStudent(String enrollment) {
		boolean f = false;

		// Creating Connection

		try {
			Connection con = ConnectionProvider.CreateConnection();
			String query = "delete from student where Enrollment_No=?";

			PreparedStatement statement = con.prepareStatement(query);

			statement.setString(1, enrollment);

			int t = statement.executeUpdate();
			System.out.println("\nNumber of rows affected: " + t);
			f = true;
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

//	Show All Student 
	public static void showallStudent() throws Exception {

		Connection con = ConnectionProvider.CreateConnection();
		String query = "select * from student";
		Statement statement = con.createStatement();

		ResultSet set = statement.executeQuery(query);

		while (set.next()) {
			String enrollment = set.getString(1);
			String name = set.getString(2);
			String email = set.getString(3);
			String phone = set.getString(4);
			int semester = set.getInt(5);

			System.out.println(
					"\n********************************************************************************************");
			System.out.println("Enrollment_No: " + enrollment);
			System.out.println("Student_Name: " + name);
			System.out.println("Student_Email: " + email);
			System.out.println("Student_Phone: " + phone);
			System.out.println("Semester: " + semester);
			System.out.println(
					"********************************************************************************************\n");
		}
		con.close();
	}

//	Show Student By Semester
	public static void showallStudentBySemester(int sem) {

		Connection con;
		try {
			con = ConnectionProvider.CreateConnection();
			String query = "SELECT * FROM student WHERE Semester=?";
			try (PreparedStatement statement = con.prepareStatement(query)) {

				statement.setInt(1, sem);

				try (ResultSet resultSet = statement.executeQuery()) {

					while (resultSet.next()) {
						String enrollment = resultSet.getString(1);
						String name = resultSet.getString(2);
						String email = resultSet.getString(3);
						String phone = resultSet.getString(4);
						int semester = resultSet.getInt(5);

						System.out.println(
								"\n********************************************************************************************");
						System.out.println("Enrollment_No: " + enrollment);
						System.out.println("Student_Name: " + name);
						System.out.println("Student_Email: " + email);
						System.out.println("Student_Phone: " + phone);
						System.out.println("Semester: " + semester);
						System.out.println(
								"********************************************************************************************\n");
					}
					con.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Update Operation 	
	public static void updateName(String enrollment, String name) {
		Connection con = null;
		try {
			con = ConnectionProvider.CreateConnection();
			String query = "UPDATE student SET Student_Name=? WHERE Enrollment_No=?";
			try (PreparedStatement statement = con.prepareStatement(query)) {
				statement.setString(1, name);
				statement.setString(2, enrollment);

				int rowsAffected = statement.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Update successful for enrollment: " + enrollment);
				} else {
					System.out.println("No rows updated for enrollment: " + enrollment);
				}
				System.out.println("\nNo. of Rows affected: " + rowsAffected);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the database connection
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updateEmail(String enrollment, String email) {
		Connection con = null;
		try {
			con = ConnectionProvider.CreateConnection();
			String query = "UPDATE student SET Student_Email=? WHERE Enrollment_No=?";
			try (PreparedStatement statement = con.prepareStatement(query)) {
				statement.setString(1, email);
				statement.setString(2, enrollment);

				int rowsAffected = statement.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Update successful for enrollment: " + enrollment);
				} else {
					System.out.println("No rows updated for enrollment: " + enrollment);
				}
				System.out.println("\nNo. of Rows affected: " + rowsAffected);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the database connection
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updatePhone(String enrollment, String phone) {
		Connection con = null;
		try {
			con = ConnectionProvider.CreateConnection();
			String query = "UPDATE student SET Student_Phone=? WHERE Enrollment_No=?";
			try (PreparedStatement statement = con.prepareStatement(query)) {
				statement.setString(1, phone);
				statement.setString(2, enrollment);

				int rowsAffected = statement.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Update successful for enrollment: " + enrollment);
				} else {
					System.out.println("No rows updated for enrollment: " + enrollment);
				}
				System.out.println("\nNo. of Rows affected: " + rowsAffected);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the database connection
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updateSemester(String enrollment, int semester) {
		Connection con = null;
		try {
			con = ConnectionProvider.CreateConnection();
			String query = "UPDATE student SET Semester=? WHERE Enrollment_No=?";
			try (PreparedStatement statement = con.prepareStatement(query)) {
				statement.setInt(1, semester);
				statement.setString(2, enrollment);

				int rowsAffected = statement.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Update successful for enrollment: " + enrollment);
				} else {
					System.out.println("No rows updated for enrollment: " + enrollment);
				}
				System.out.println("\nNo. of Rows affected: " + rowsAffected);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the database connection
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
