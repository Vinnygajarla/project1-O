package project;


import java.util.List;

public class StudentBAL {

	static StringBuilder sb = new StringBuilder();
	
	public String deleteStudentBal(int sno) {
		return new StudentDAO().deleteStudentDao(sno);
	}
	public Student searchStudentBal(int sno) {
		return new StudentDAO().searchStudentDao(sno);
	}
	
	public String updateStudentBal(Student student) throws StudentException {
		if(validateStudent(student)==true) {
			return new StudentDAO().updateStudentDao(student);
		} else {
			throw new StudentException(sb.toString());
		}
	}
	public String addStudentBal(Student student) throws StudentException {
		if(validateStudent(student)==true) {
			return new StudentDAO().addStudentDao(student);
		} else {
			throw new StudentException(sb.toString());
		}
	}
	
	public List<Student> showStudentBal() {
		return new StudentDAO().showStudentDao();
	}
	public boolean validateStudent(Student student) {
		boolean isValid=true;
		if (student.getSno() <= 0) {
			sb.append("Student No Cannot be Zero or Negative\n");
			isValid=false;
		}
		if (student.getName().length() < 5) {
			sb.append("Student Name Contains Min. 5 chars\n");
			isValid=false;
		}
		
		if (student.getCity().length() < 3) {
			sb.append("City Contains min. 3 characters\n");
			isValid=false;
		}
		
		if (student.getCgp() <= 0) {
			sb.append("Student CGP Cannot be Zero or Negative...");
			isValid=false;
		}
		return isValid;
	}
}
