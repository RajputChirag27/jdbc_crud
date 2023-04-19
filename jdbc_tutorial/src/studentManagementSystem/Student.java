package studentManagementSystem;

public class Student {

// Generating Variables
	private String enrollmentNumber;
	private String studentName;
	private String studentEmail;
	private String studentPhone;
	private int semester;

// Creating Constructors
	public Student(String enrollmentNumber, String studentName, String studentEmail, String studentPhone,
			int semester) {
		super();
		this.enrollmentNumber = enrollmentNumber;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.semester = semester;
	}

// Getters and Setters
	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}

	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

//Overriding to String method

	@Override
	public String toString() {
		return "Student [enrollmentNumber=" + enrollmentNumber + ", studentName=" + studentName + ", studentEmail="
				+ studentEmail + ", studentPhone=" + studentPhone + ", semester=" + semester + "]";
	}

}
