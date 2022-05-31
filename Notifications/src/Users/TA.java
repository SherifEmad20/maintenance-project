package Users;

public class TA extends Users {

	private String department;

	public TA(String name, String department, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.department = department;
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
