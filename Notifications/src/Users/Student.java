package Users;

import Course.Course;
import Gateways.EmailGateway;
import Gateways.SMSGateway;
import Gateways.GatewayContext;

public class Student extends Users {

	int id;
	String message;
	String studentt = "Student";

	Course courses;

	public Student(String name, int id, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.id = id;
	}

	@Override
	public void daliyNewsEmailGateway() {
		m.getMessage("DailyNewsEmailMessage");
		c = new GatewayContext(new EmailGateway());
		c.executeStrategy(m, studentt);

	}

	@Override
	public void daliyNewsSMSGateway() {
		m.getMessage("DailyNewsMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, studentt);
	}

	@Override
	public void gradesAnnouncementEmailGateway() {
		m.getMessage("GradesAnnouncementEmailMessage");
		c = new GatewayContext(new EmailGateway());
		c.executeStrategy(m, studentt);
	}

	@Override
	public void gradesAnnouncementSMSGateway() {
		m.getMessage("GradesAnnouncementMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, studentt);
	}

	@Override
	public void taskAddedEmailGateway() {
		m.getMessage("TaskAddedEmailMessage");
		c = new GatewayContext(new EmailGateway());
		c.executeStrategy(m, studentt);
	}

	@Override
	public void taskAddedSMSGateway() {
		m.getMessage("TaskAddedMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, studentt);
	}

	@Override
	public void update() {
		// do some logic
		System.out.println("New tasks: " + this.course.getAssignment());
		System.out.println("New grades: " + this.course.getGrades());
		System.out.println("New daliy news: " + this.course.getNews());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void notifyStudent(String message) {
		// do some stuff
		this.message = message;
		this.courses.subscribeStudentForEmailNotification(this);
		this.courses.subscribeStudentForSMSNotification(this);

	}

}
