package Course;

import java.util.*;

import Users.*;
import Gateways.*;
import Messages.*;

public class Course {

	private String name;
	private String code;
	private MessageFactory msgFactory;

	private ArrayList<String> announcements;
	private ArrayList<String> exams;
	private ArrayList<String> grades;
	private ArrayList<String> news;

	private ArrayList<Professor> professorsForEmailNotification;
	private ArrayList<Professor> professorsForSMSNotification;

	private ArrayList<TA> TAsForEmailNotification;
	private ArrayList<TA> TAsForSMSNotification;

	private ArrayList<Student> studentsForEmailNotification;
	private ArrayList<Student> studentsForSMSNotification;

	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;

		this.msgFactory = new MessageFactory();
		announcements = new ArrayList<>();
		exams = new ArrayList<>();
		grades = new ArrayList<>();
		news = new ArrayList<>();

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

	public void addExams(String exam) {
		exams.add(exam);
		String[] placeholders = new String[] { exam };

		notifyAllUsersSMS(placeholders);
		notifyAllUsersEmail(placeholders);
	}

	public void addAssignment(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] { assignName, assignBody };
		// do some logic here

		notifyAllUsersSMS(placeholders);
		notifyAllUsersEmail(placeholders);
	}

	public void addGrades(String grade) {
		grades.add(grade);
		String[] placeholders = new String[] { grade };
		// do some logic here

		notifyAllUsersSMS(placeholders);
		notifyAllUsersEmail(placeholders);

	}

	public void addNews(String dailyNews) {
		news.add(dailyNews);
		String[] placeholders = new String[] { dailyNews };
		// do some logic here

		notifyAllUsersSMS(placeholders);
		notifyAllUsersEmail(placeholders);
	}

	public Object[] getAssignment() {
		return announcements.toArray();
	}

	public Object[] getGrades() {
		return grades.toArray();
	}

	public Object[] getNews() {
		return news.toArray();
	}

	public Object[] getExams() {
		return exams.toArray();
	}
	// AddExam, PostGrades, PostAnnouncement will be the same

	private void notifyAllUsersSMS(String[] placeholders) {
		// notify users by SMS
		Message newsSMS = msgFactory.getMessage("DailyNewsMobileMessage");
		Message gradesSMS = msgFactory.getMessage("GradesAnnouncementMobileMessage");
		Message tasksSMS = msgFactory.getMessage("TaskAddedMobileMessage");
		String newsNotificationSMS = newsSMS.prepareMessage(placeholders);
		String gradesNotificationSMS = gradesSMS.prepareMessage(placeholders);
		String tasksNotificationSMS = tasksSMS.prepareMessage(placeholders);

		// open connection for SMS gateway and do some configurations to the object
		GatewayContext msgGateway = new GatewayContext(new SMSGateway());

		for (Professor professor : professorsForEmailNotification) {
			professor.notifyProfessor(newsNotificationSMS);
			professor.notifyProfessor(gradesNotificationSMS);
			professor.notifyProfessor(tasksNotificationSMS);
			msgGateway.executeStrategy(newsNotificationSMS, professor.getPhoneNumber());
			msgGateway.executeStrategy(gradesNotificationSMS, professor.getPhoneNumber());
			msgGateway.executeStrategy(tasksNotificationSMS, professor.getPhoneNumber());
		}

		for (TA ta : TAsForEmailNotification) {
			ta.notifyTA(newsNotificationSMS);
			ta.notifyTA(gradesNotificationSMS);
			ta.notifyTA(tasksNotificationSMS);
			msgGateway.executeStrategy(newsNotificationSMS, ta.getPhoneNumber());
			msgGateway.executeStrategy(gradesNotificationSMS, ta.getPhoneNumber());
			msgGateway.executeStrategy(tasksNotificationSMS, ta.getPhoneNumber());
		}

		for (Student student : studentsForSMSNotification) {
			student.notifyStudent(newsNotificationSMS);
			student.notifyStudent(gradesNotificationSMS);
			student.notifyStudent(tasksNotificationSMS);
			msgGateway.executeStrategy(newsNotificationSMS, student.getPhoneNumber());
			msgGateway.executeStrategy(gradesNotificationSMS, student.getPhoneNumber());
			msgGateway.executeStrategy(tasksNotificationSMS, student.getPhoneNumber());
		}
	}

	private void notifyAllUsersEmail(String[] placeholders) {
		// notify users by Email
		Message newsEmail = msgFactory.getMessage("DailyNewsEmailMessage");
		Message gradesEmail = msgFactory.getMessage("GradesAnnouncementEmailMessage");
		Message tasksEmail = msgFactory.getMessage("TaskAddedEmailMessage");
		String newsNotificationEmail = newsEmail.prepareMessage(placeholders);
		String gradesNotificationEmail = gradesEmail.prepareMessage(placeholders);
		String tasksNotificationEmail = tasksEmail.prepareMessage(placeholders);

		// open connection for Email gateway and do some configurations to the object
		GatewayContext msgGateway = new GatewayContext(new EmailGateway());

		for (Professor professor : professorsForEmailNotification) {
			professor.notifyProfessor(newsNotificationEmail);
			professor.notifyProfessor(gradesNotificationEmail);
			professor.notifyProfessor(tasksNotificationEmail);
			msgGateway.executeStrategy(newsNotificationEmail, professor.getEmail());
			msgGateway.executeStrategy(gradesNotificationEmail, professor.getEmail());
			msgGateway.executeStrategy(tasksNotificationEmail, professor.getEmail());
		}

		for (TA ta : TAsForEmailNotification) {
			ta.notifyTA(newsNotificationEmail);
			ta.notifyTA(gradesNotificationEmail);
			ta.notifyTA(tasksNotificationEmail);
			msgGateway.executeStrategy(newsNotificationEmail, ta.getEmail());
			msgGateway.executeStrategy(gradesNotificationEmail, ta.getEmail());
			msgGateway.executeStrategy(tasksNotificationEmail, ta.getEmail());
		}

		for (Student student : studentsForSMSNotification) {
			student.notifyStudent(newsNotificationEmail);
			student.notifyStudent(gradesNotificationEmail);
			student.notifyStudent(tasksNotificationEmail);
			msgGateway.executeStrategy(newsNotificationEmail, student.getEmail());
			msgGateway.executeStrategy(gradesNotificationEmail, student.getEmail());
			msgGateway.executeStrategy(tasksNotificationEmail, student.getEmail());
		}
	}

}
