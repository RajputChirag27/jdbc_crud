package studentManagementSystem;

import java.io.*;

public class Menu {
	public static void main(String args[]) throws Exception {

		System.out.println("**********	Welcome to Student Management System	**********\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\nPress 1 to Add Student Data");
			System.out.println("Press 2 to Delete Student Data");
			System.out.println("Press 3 to Update Student Data");
			System.out.println("Press 4 to Display Student Data");
			System.out.println("Press 5 to Display Student Data of Particular Semester");
			System.out.println("Press 6 to Exit");
			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				// Add Student
				System.out.println("Enter Student's Enrollment Number");
				String enrollment = br.readLine();

				System.out.println("Enter Student's Name");
				String name = br.readLine();

				System.out.println("Enter Student's Email");
				String email = br.readLine();

				System.out.println("Enter Student's Mobile Number");
				String mobile = br.readLine();

				System.out.println("Enter Semester of the Student");
				int sem = Integer.parseInt(br.readLine());

				Student st = new Student(enrollment, name, email, mobile, sem);

//				Checking if values have been inserted into database successfully or not
				boolean ans = CRUDStudent.addStudent(st);
				if (ans) {
					System.out.println("\n Data Inserted Successfully.....\n");
				} else {
					System.out.println("\nSomething went Wrong.....\n");
				}

				System.out.println(st);
				System.out.println();
			}

			else if (c == 2) {
				// Delete Student
				System.out.println("Enter Student's Enrollment No. to delete the record");
				String enrollment = br.readLine();
				boolean ans = CRUDStudent.deleteStudent(enrollment);
				if (ans) {
					System.out.println("\nData Deleted Successfully.....\n");
				} else {
					System.out.println("\nSomething went Wrong.....\n");
				}
				System.out.println();
			}

			else if (c == 3) {
				// Update Student

				System.out.println("\n\n\n............ Welcome to update section ............\n\n");
				System.out.println("\nPress 1 to update Student Name");
				System.out.println("Press 2 to update Student Email");
				System.out.println("Press 3 to update Student Phone");
				System.out.println("Press 4 to update Semester");
				System.out.println("Press 5 to exit");

				int a = Integer.parseInt(br.readLine());
				System.out.println("Enter the Enrollment Number");
				String enrollment = br.readLine();
				while (true) {
					if (a == 1) {
						System.out.println("Enter the name to update");
						String name = br.readLine();
						CRUDStudent.updateName(enrollment, name);
						break;
					} else if (a == 2) {
						System.out.println("Enter the email to update");
						String email = br.readLine();
						CRUDStudent.updateEmail(enrollment, email);
						break;
					} else if (a == 3) {
						System.out.println("Enter the phone no. to update");
						String phone = br.readLine();
						CRUDStudent.updatePhone(enrollment, phone);
						break;
					} else if (a == 4) {
						System.out.println("Enter the semester to update");
						int semester = Integer.parseInt(br.readLine());
						CRUDStudent.updateSemester(enrollment, semester);
						break;
					} else if (a == 5) {
						break;
					} else {
						System.out.println("You have Entered Wrong Choice");
					}

				}
			}

			else if (c == 4) {
				// Display Student
				CRUDStudent.showallStudent();
			}

			else if (c == 5) {
				// Display Student at Particular Semester
				System.out.println("Enter the Semester of the Student");
				int sem = Integer.parseInt(br.readLine());
				CRUDStudent.showallStudentBySemester(sem);
			}

			else if (c == 6) {
				// Exit App
				break;
			} else {
				System.out.println("You have Entered Wrong Choice");
			}
		}
		System.out.println("Application Closed Successfully");
		System.out.println("See you Again!!");
	}
}
