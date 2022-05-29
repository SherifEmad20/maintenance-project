package Users;

import java.sql.Date;

import Course.Course;
import Gateways.EmailGateway;
import Gateways.SMSGateway;
import Gateways.GatewayContext;

public class Professor extends Users {

	Date hirringDate;
	String PhDTopic;
	String message;
	String department;
	Course courses;

	String professorr = "Professor";

	public Professor(String name, String department, Date hirringDate, String phDTopic, String email,
			String phoneNumber) {
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
		c.executeStrategy(m, professorr);

	}

	@Override
	public void daliyNewsSMSGateway() {
		m.getMessage("DailyNewsMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, professorr);
	}

	@Override
	public void gradesAnnouncementEmailGateway() {
		m.getMessage("GradesAnnouncementEmailMessage");
		c = new GatewayContext(new EmailGateway());
		c.executeStrategy(m, professorr);
	}

	@Override
	public void gradesAnnouncementSMSGateway() {
		m.getMessage("GradesAnnouncementMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, professorr);
	}

	@Override
	public void taskAddedEmailGateway() {
		m.getMessage("TaskAddedEmailMessage");
		c = new GatewayContext(new EmailGateway());
		c.executeStrategy(m, professorr);
	}

	@Override
	public void taskAddedSMSGateway() {
		m.getMessage("TaskAddedMobileMessage");
		c = new GatewayContext(new SMSGateway());
		c.executeStrategy(m, professorr);
	}

	@Override
	public void update() {
		// do some logic
		System.out.println("New tasks: " + this.course.getAssignment());
		System.out.println("New grades: " + this.course.getGrades());
		System.out.println("New daliy news: " + this.course.getNews());
	}

	public Date getHirringDate() {
		return hirringDate;
	}

	public void setHirringDate(Date hirringDate) {
		this.hirringDate = hirringDate;
	}

	public String getPhDTopic() {
		return PhDTopic;
	}

	public void setPhDTopic(String phDTopic) {
		PhDTopic = phDTopic;
	}

	public void notifyProfessor(String message) {
		// do some stuff
		this.message = message;
		this.courses.subscribeProfessorForEmailNotification(this);
		this.courses.subscribeProfessorForSMSNotification(this);
	}

}
