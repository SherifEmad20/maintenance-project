package Messages;

public class TaskAddedMobileMessage implements message{

	@Override
	public String prepareMessage(String placeHolders[]) {
		// code to replace place holders of this type
		return "New task has been added";
	}
	
	
	public void addTeamDescription() {
		
	}
}
