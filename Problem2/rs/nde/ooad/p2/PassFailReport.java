package rs.nde.ooad.p2;

public class PassFailReport implements Observer {
	private SubmissionSubject subject;
	private int passed;
	private int total;
	
	public PassFailReport(SubmissionSubject subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
			total += 1;
		if (!this.subject.hasFailed()) {
			passed += 1;
		}
	}
	
	@Override
	public String toString() {
		return "Observed " + passed + " successes out of " + total + " tests.";
	}
}
