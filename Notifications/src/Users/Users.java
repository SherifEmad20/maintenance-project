package Users;

import Course.*;

public abstract class Users {

	private String name;
	private String email;
	private String phoneNumber;
	private Course c;
	private Professor professor;
	private Student student;
	private TA ta;

	protected Users(Course c) {
		this.c = c;
		c.subscribeProfessorForEmailNotification(professor);
		c.subscribeProfessorForSMSNotification(professor);

		c.subscribeStudentForEmailNotification(student);
		c.subscribeStudentForSMSNotification(student);

		c.subscribeTAForEmailNotification(ta);
		c.subscribeTAForSMSNotification(ta);
	}

	protected Users(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void daliyNewsEmailGateway() {
		System.out.println("New daily news updated: " + c.getNews());
		System.out.println("New exmas updated: " + c.getExams());
	}

	public void daliyNewsSMSGateway() {
		System.out.println("Daily news updated: " + c.getNews());
		System.out.println("New exmas uploaded: " + c.getExams());
	}

	public void gradesAnnouncementEmailGateway() {
		System.out.println("New grades uploaded: " + c.getGrades());
	}

	public void gradesAnnouncementSMSGateway() {
		System.out.println("New grades uploaded: " + c.getGrades());
	}

	public void taskAddedEmailGateway() {
		System.out.println("New tasks uploaded: " + c.getAssignment());
	}

	public void taskAddedSMSGateway() {
		System.out.println("New tasks uploaded: " + c.getAssignment());
	}

}
