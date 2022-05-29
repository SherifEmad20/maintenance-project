package Messages;

public class DailyNewsEmailMessage implements Message {

	@Override
	public String prepareMessage(String[] placeHolders) {
		// code to replace place holders of this type
		return "New news added";
	}
}
