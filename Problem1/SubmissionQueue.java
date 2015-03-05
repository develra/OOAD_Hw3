import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author develra
 *
 */
public class SubmissionQueue {
	 
	private static SubmissionQueue instance = null;
	private List<Submission> queue;
	private SubmissionQueue() {
		this.queue = new ArrayList<Submission>();
	}

	public synchronized static SubmissionQueue getInstance() {
		if(instance == null)
			instance = new SubmissionQueue();
		return instance; 
	}

	/** Add the given submission onto our queue
	 * @param s - The submission to queue
	 */
	public synchronized void add(Submission s) {
		this.queue.add(s);
	}
	
	/** Remove and return a submission off of the queue.
	 * @return Submission - The next submission to process
	 */
	public synchronized Submission process() {
		return this.queue.remove(0);
	}
}