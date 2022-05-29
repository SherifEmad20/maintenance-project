package Messages;

public class DailyNewsMobileMessage implements Message{
	
	@Override
	public String prepareMessage(String[] placeHolders) {
		// code to replace place holders of this type
		return "New news added";
	}
}
