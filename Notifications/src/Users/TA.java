package Users;

import Course.Course;
import Gateways.EmailGateway;
import Gateways.SMSGateway;
import Gateways.GatewayContext;

public class TA extends Users {

	String department;
	String message;
	String teacher = "TA";

	Course courses;

	public TA(String name, String department, String email, String phoneNumber) {
		super(name, email, phoneNumber);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public void daliyNewsEmailGateway() {
		m.getMessage("DailyNewsEmailMessage");
		c = new GatewayContext(new EmailGateway());
		c.executeStrategy(m, teacher);

	}

	@Override
	public void daliyNewsSMSGateway() {
		m.getMessage("DailyNewsMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, teacher);
	}

	@Override
	public void gradesAnnouncementEmailGateway() {
		m.getMessage("GradesAnnouncementEmailMessage");
		c = new GatewayContext(new EmailGateway());
		c.executeStrategy(m, teacher);
	}

	@Override
	public void gradesAnnouncementSMSGateway() {
		m.getMessage("GradesAnnouncementMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, teacher);
	}

	@Override
	public void taskAddedEmailGateway() {
		m.getMessage("TaskAddedEmailMessage");
		c = new GatewayContext(new EmailGateway());
		c.executeStrategy(m, teacher);
	}

	@Override
	public void taskAddedSMSGateway() {
		m.getMessage("TaskAddedMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, teacher);
	}

	@Override
	public void update() {
		// do some logic
		System.out.println("New tasks: " + this.course.getAssignment());
		System.out.println("New grades: " + this.course.getGrades());
		System.out.println("New daliy news: " + this.course.getNews());
	}

	public void notifyTA(String message) {
		// do some stuff
		this.message = message;
		this.courses.subscribeTAForEmailNotification(this);
		this.courses.subscribeTAForSMSNotification(this);

	}

}
