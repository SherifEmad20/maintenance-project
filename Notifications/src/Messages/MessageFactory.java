package Messages;

public class MessageFactory {

	public Message getMessage(String messageType) {
		if (messageType == null) {
			return null;
		}

		else if (messageType.equals("DailyNewsEmailMessage")) {
			return new DailyNewsEmailMessage();
		}

		else if (messageType.equals("DailyNewsMobileMessage")) {
			return new DailyNewsMobileMessage();
		}

		else if (messageType.equals("GradesAnnouncementEmailMessage")) {
			return new GradesAnnouncementEmailMessage();
		}

		else if (messageType.equals("GradesAnnouncementMobileMessage")) {
			return new GradesAnnouncementMobileMessage();
		}

		else if (messageType.equals("TaskAddedEmailMessage")) {
			return new TaskAddedEmailMessage();
		}

		else if (messageType.equals("TaskAddedMobileMessage")) {
			return new TaskAddedMobileMessage();
		}

		return null;

	}

}
