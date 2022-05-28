package Users;

import java.sql.Date;

import Gateways.EmailGateway;
import Gateways.SMSGateway;
import Gateways.gatewayContext;

public class Professor extends Users{
	Date hirringDate;
	String PhDTopic;
	
	
	public Professor(String name, String department, Date hirringDate, String phDTopic, String email,
			String phoneNumber) {
		super(name,email,phoneNumber,department);
	}
	
	public void daliyNewsEmailGateway() {
		m.getMessage("DailyNewsEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "Professor");

	}

	public void daliyNewsSMSGateway() {
		m.getMessage("DailyNewsMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "Professor");
	}

	public void GradesAnnouncementEmailGateway() {
		m.getMessage("GradesAnnouncementEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "Professor");
	}

	public void GradesAnnouncementSMSGateway() {
		m.getMessage("GradesAnnouncementMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "Professor");
	}

	public void TaskAddedEmailGateway() {
		m.getMessage("TaskAddedEmailMessage");
		c = new gatewayContext(new EmailGateway());
		c.executeStrategy(m, "Professor");
	}

	public void TaskAddedSMSGateway() {
		m.getMessage("TaskAddedMobileMessage");
		c = new gatewayContext(new SMSGateway());
		c.executeStrategy(m, "Professor");
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
		
	}
	
	
	
}
