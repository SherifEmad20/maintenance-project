package Users;

import Gateways.GatewayContext;
import Messages.messageFactory;
import Course.Course;

public abstract class Users {

	String name;
	String email;
	String phoneNumber;
	messageFactory m;
	GatewayContext c;

	Course course;

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

	public abstract void daliyNewsEmailGateway();

	public abstract void daliyNewsSMSGateway();

	public abstract void gradesAnnouncementEmailGateway();

	public abstract void gradesAnnouncementSMSGateway();

	public abstract void taskAddedEmailGateway();

	public abstract void taskAddedSMSGateway();

	public abstract void update();

}
