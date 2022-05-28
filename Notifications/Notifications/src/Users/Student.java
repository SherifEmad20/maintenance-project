package Users;

import Gateways.EmailGateway;
import Gateways.SMSGateway;
import Gateways.gatewayContext;

public class Student extends Users {
	int Id;

	public Student(String name, int id, String email, String phoneNumber) {
		super(name, email, phoneNumber, null);
		Id = id;
	}

	public void daliyNewsEmailGateway() {
		m.getMessage("DailyNewsEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "Student");

	}

	public void daliyNewsSMSGateway() {
		m.getMessage("DailyNewsMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "Student");
	}

	public void GradesAnnouncementEmailGateway() {
		m.getMessage("GradesAnnouncementEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "Student");
	}

	public void GradesAnnouncementSMSGateway() {
		m.getMessage("GradesAnnouncementMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "Student");
	}

	public void TaskAddedEmailGateway() {
		m.getMessage("TaskAddedEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "Student");
	}

	public void TaskAddedSMSGateway() {
		m.getMessage("TaskAddedMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "Student");
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public void notifyStudent(String message) {
		// do some stuff
	}

}
