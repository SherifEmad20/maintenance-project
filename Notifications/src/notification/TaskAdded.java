package notification;

public class TaskAdded extends notification {

	String tasks;

	public void addTasks(String task) {
		this.tasks = task;
	}

	public String notifyTasks() {
		return tasks;
	}

}
