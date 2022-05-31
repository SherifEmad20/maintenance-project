package Users;

public class Student extends Users {

	private int id;

	public Student(String name, int id, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void notifyStudent(String message) {
		// do some stuff
	}

}
