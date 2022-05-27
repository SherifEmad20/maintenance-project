package notification;

public class GradesAnnouncement extends notification{

	double grades;

	public void addGrades(double grades) {
		this.grades = grades;
	}

	public double notifyGrades() {
		return grades;
	}
}
