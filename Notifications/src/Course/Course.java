package Course;

import java.util.ArrayList;

import Gateways.EmailGateway;
import Messages.TaskAddedEmailMessage;
import Users.Professor;
import Users.Student;
import Users.TA;

public class Course {

	String name;
	String code;
	ArrayList<String> announcements;
	ArrayList<String> exams;
	ArrayList<String> grades;
	ArrayList<String> news;

	ArrayList<Professor> professorsForEmailNotification;
	ArrayList<Professor> professorsForSMSNotification;

	ArrayList<TA> TAsForEmailNotification;
	ArrayList<TA> TAsForSMSNotification;

	ArrayList<Student> studentsForEmailNotification;
	ArrayList<Student> studentsForSMSNotification;

	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;

		announcements = new ArrayList<>();
		exams = new ArrayList<>();
		grades = new ArrayList<>();

		professorsForEmailNotification = new ArrayList<>();
		professorsForSMSNotification = new ArrayList<>();

		TAsForEmailNotification = new ArrayList<>();
		TAsForSMSNotification = new ArrayList<>();

		studentsForEmailNotification = new ArrayList<>();
		studentsForSMSNotification = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void subscribeProfessorForEmailNotification(Professor professor) {
		professorsForEmailNotification.add(professor);
	}

	public void subscribeProfessorForSMSNotification(Professor professor) {
		professorsForSMSNotification.add(professor);
	}

	public void subscribeTAForEmailNotification(TA ta) {
		TAsForEmailNotification.add(ta);
	}

	public void subscribeTAForSMSNotification(TA ta) {
		TAsForSMSNotification.add(ta);
	}

	public void subscribeStudentForEmailNotification(Student student) {
		studentsForEmailNotification.add(student);
	}

	public void subscribeStudentForSMSNotification(Student student) {
		studentsForSMSNotification.add(student);
	}

	public void addAssignment(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] { assignName, assignBody };
		// do some logic here

		notifyAllUsers(placeholders);
	}

	public void addGrades(String grade) {
		grades.add(grade);
		String[] placeholders = new String[] { grade };
		// do some logic here

		notifyAllUsers(placeholders);
	}

	public void addNews(String dailyNews) {
		news.add(dailyNews);
		String[] placeholders = new String[] { dailyNews };
		// do some logic here

		notifyAllUsers(placeholders);
	}

	public ArrayList<String> getAssignment() {
		return announcements;
	}

	public ArrayList<String> getGrades() {
		return grades;
	}

	public ArrayList<String> getNews() {
		return news;
	}

	// AddExam, PostGrades, PostAnnouncement will be the same

	private void notifyAllUsers(String[] placeholders) {
		// notify users by email
		TaskAddedEmailMessage msg = new TaskAddedEmailMessage();
		String notification = msg.prepareMessage(placeholders);

		// open connection for Email gateway and do some configurations to the object

		EmailGateway emailGateway = new EmailGateway();

		for (Professor professor : professorsForEmailNotification) {
			professor.notifyProfessor(notification);
			emailGateway.sendMessage(notification, professor.getEmail());
		}

		for (TA ta : TAsForEmailNotification) {
			ta.notifyTA(notification);
			emailGateway.sendMessage(notification, ta.getEmail());
		}

		for (Student student : studentsForSMSNotification) {
			student.notifyStudent(notification);
			emailGateway.sendMessage(notification, student.getEmail());
		}
	}

}
