package Messages;

public class GradesAnnouncementEmailMessage implements Message{

	@Override
	public String prepareMessage(String[] placeHolders) {
		// code to replace place holders of this type
		return "Dear{Student X}, The grade of task {Task X} is announced and you can find it at students grades";
	}
	
	public boolean verifyGrades() {
		// code to verify Grades before announcement
		
		return true;
	}
}
