package Users;

public class TA {
	String name;
	String department;
	String email;
	String phoneNumber;
	
	

	public TA(String name, String department, String email, String phoneNumber) {
		super();
		this.name = name;
		this.department = department;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void notifyTA(String message) {
		// do some stuff
		
	}
	
}
