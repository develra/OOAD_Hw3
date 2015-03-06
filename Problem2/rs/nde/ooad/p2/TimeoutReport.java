package rs.nde.ooad.p2;

public class TimeoutReport implements Observer, Report {
	private SubmissionSubject subject;
	private int timedOut;
	private int total;

	public TimeoutReport(SubmissionSubject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void update() {
		total += 1;
		if (this.subject.wasTimeoutError()) {
			timedOut += 1;
		}
	}

	@Override
	public String getReport() {
		return "TimedReport: Observed " + timedOut + " timeouts out of " + total + " total submissions.";
	}
}