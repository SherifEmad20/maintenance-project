package Users;

import Gateways.EmailGateway;
import Gateways.SMSGateway;
import Gateways.gatewayContext;

public class TA extends Users {

	public TA(String name, String department, String email, String phoneNumber) {
		super(name, email, phoneNumber, department);
	}


	public void daliyNewsEmailGateway() {
		m.getMessage("DailyNewsEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "TA");

	}

	public void daliyNewsSMSGateway() {
		m.getMessage("DailyNewsMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "TA");
	}

	public void GradesAnnouncementEmailGateway() {
		m.getMessage("GradesAnnouncementEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "TA");
	}

	public void GradesAnnouncementSMSGateway() {
		m.getMessage("GradesAnnouncementMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "TA");
	}

	public void TaskAddedEmailGateway() {
		m.getMessage("TaskAddedEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "TA");
	}

	public void TaskAddedSMSGateway() {
		m.getMessage("TaskAddedMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "TA");
	}

	public void notifyTA(String message) {
		// do some stuff

	}

}
