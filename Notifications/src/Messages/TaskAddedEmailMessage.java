package Messages;

public class TaskAddedEmailMessage implements Message {

	@Override
	public String prepareMessage(String[] placeHolders) {
		// code to replace place holders of this type

		return "New task has been added";
	}

	public void addTeamDescription() {
		// do some logic
	}
}
