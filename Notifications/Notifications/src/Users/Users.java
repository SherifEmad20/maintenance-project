package Users;

import Gateways.gatewayContext;
import Messages.messageFactory;

public abstract class Users {

	String name;
	String department;
	String email;
	String phoneNumber;
	messageFactory m;
	gatewayContext c;

	public Users(String name, String email, String phoneNumber, String department) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.department = department;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
