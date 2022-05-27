package notification;

public class Daily_News extends notification {

	String news;

	public void addNews(String news) {
		this.news = news;
	}

	public String notifyNews() {
		return news;
	}

}
