package rs.nde.ooad.p2;

public class TimeoutReport implements Observer {
	private SubmissionSubject subject;
	private int timedOut;
	private int total;

	public TimeoutReport(SubmissionSubject subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		total += 1;
		if (!this.subject.wasTimeoutError()) {
			timedOut += 1;
		}
	}

	@Override
	public String toString() {
		return "Observed " + timedOut + " timeouts out of " + total + " total submissions.";
	}
}