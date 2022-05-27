package notification;

import java.util.ArrayList;

import Users.Professor;
import Users.Student;
import Users.TA;

public class notification {

	ArrayList<Student> students;
	ArrayList<TA> TAs;
	ArrayList<Professor> professors;

	public void attachStudent(Student student) {
		this.students.add(student);
	}

	public void detachStudent(Student student) {
		this.students.remove(student);
	}

	public void attachTA(TA ta) {
		this.TAs.add(ta);
	}

	public void detachTA(TA ta) {
		this.TAs.remove(ta);

	}

	public void attachProfessor(Professor professor) {
		this.professors.add(professor);
	}

	public void detachProfessor(Professor professor) {
		this.professors.remove(professor);
	}

	public void notifyStudent() {

	}

	public void notifyTA() {

	}

	public void notifyProfessor() {

	}

}
