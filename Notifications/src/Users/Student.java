package Users;

public class Student {
	String name;
	int Id;
	String email;
	String phoneNumber;
	
	
	
	public Student(String name, int id, String email, String phoneNumber) {
		super();
		this.name = name;
		Id = id;
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
