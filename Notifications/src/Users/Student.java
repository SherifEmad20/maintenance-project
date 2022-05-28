package Users;

public class Student extends Users{
	int Id;
	
	
	
	public Student(String name, int id, String email, String phoneNumber) {
		super(name,email,phoneNumber,null);
		Id = id;
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
