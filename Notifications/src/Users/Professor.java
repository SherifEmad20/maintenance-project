package Users;

import java.sql.Date;

public class Professor extends Users {
	Date hirringDate;
	String PhDTopic;

	public Professor(String name, String department, Date hirringDate, String phDTopic, String email,
			String phoneNumber) {
		super(name, email, phoneNumber, department);
		this.hirringDate = hirringDate;
		PhDTopic = phDTopic;
		this.email = email;
		this.phoneNumber = phoneNumber;
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
