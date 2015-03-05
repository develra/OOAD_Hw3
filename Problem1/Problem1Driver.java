import java.util.ArrayList;
import java.util.List;


public class Problem1Driver {
	private static int numThreads = 100;
	private static List<Thread> producers;
	private static List<Thread> consumers;

	public static void main(String[] args) throws InterruptedException {
        producers = new ArrayList<Thread>();
        consumers = new ArrayList<Thread>();

		for (int threadIndex = 0; threadIndex < numThreads; threadIndex++) {
			newProducerThread(1000);
		}
		
		for (int threadIndex = 0; threadIndex < numThreads; threadIndex++) {
			newConsumerThread(1000);
		}

		for (Thread producer : producers)
			producer.wait();

		for (Thread consumer: producers)
			consumer.wait();
	}
	
	public static void newProducerThread(final int numThings) {
		Runnable producer = new Runnable() {
			public void run() {
				SubmissionQueue queue = SubmissionQueue.getInstance();
				for (int index = 0; index < numThings; index++) {
					Submission newSubmission = new Submission();
					queue.add(newSubmission);
				}
			}
		};
		Thread thread = new Thread(producer);
		producers.add(thread);
		thread.start();
	}
	
	public static void newConsumerThread(final int numThings) {
		Runnable consumer = new Runnable() {
			public void run() {
				SubmissionQueue queue = SubmissionQueue.getInstance();
				for (int index = 0; index < numThings; index++) {
					Submission mySubmission = queue.process();
				}
			}
		};

		Thread thread = new Thread(consumer);
		consumers.add(thread);
		thread.start();
	}
}