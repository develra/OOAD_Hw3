package rs.nde.ooad.p2;

public class PassFailReport implements Observer, Report {
	private SubmissionSubject subject;
	private int passed;
	private int total;
	
	public PassFailReport(SubmissionSubject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void update() {
		total += 1;
		if (!this.subject.hasFailed()) {
			passed += 1;
		}
	}
	
	@Override
	public String getReport() {
		return "PassFailReport: Observed " + passed + " successes out of " + total + " total submissions.";
	}
}
