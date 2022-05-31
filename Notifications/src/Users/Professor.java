package Users;

import java.sql.Date;

public class Professor extends Users {

	private Date hirringDate;
	private String PhDTopic;
	private String department;

	public Professor(String name, String department, Date hirringDate, String phDTopic, String email,
			String phoneNumber) {
		super(name, email, phoneNumber);
		this.department = department;
		this.hirringDate = hirringDate;
		this.PhDTopic = phDTopic;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
