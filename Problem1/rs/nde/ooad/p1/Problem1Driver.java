package rs.nde.ooad.p1;
import java.util.ArrayList;
import java.util.List;


public class Problem1Driver {
	private static int numThreads = 10;
	private static int numSubmissionsPerThread = 50000;
	private static List<Thread> producers;

	private static List<Thread> consumers;

	public static void main(String[] args) throws InterruptedException {
        producers = new ArrayList<Thread>();
        consumers = new ArrayList<Thread>();
        
        System.out.println("Creating " + numThreads + " producer threads.");

		for (int threadIndex = 0; threadIndex < numThreads; threadIndex++) {
			newProducerThread(numSubmissionsPerThread);
		}

        System.out.println("Creating " + numThreads + " consumer threads.");
		
		for (int threadIndex = 0; threadIndex < numThreads; threadIndex++) {
			newConsumerThread(numSubmissionsPerThread);
		}

		for (Thread producer : producers)
			producer.join();

		for (Thread consumer: consumers)
			consumer.join();
		
		System.out.println("Finished, all submissions processed!");
	}
	
	public static void newProducerThread(final int numThings) {
		Runnable producer = new Runnable() {
			public void run() {
				SubmissionQueue queue = SubmissionQueue.getInstance();
				for (int index = 0; index < numThings; index++) {
					Submission newSubmission = new Submission();
					queue.add(newSubmission);
				}
				System.out.println("Produce finished! Produced " + Problem1Driver.numSubmissionsPerThread + " submissions.");
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
					Submission mySubmission = null;
					while (mySubmission == null) {
						mySubmission = queue.process();
					}
				}
				System.out.println("Consumer finished! Consumed " + Problem1Driver.numSubmissionsPerThread + " submissions.");
			}
		};

		Thread thread = new Thread(consumer);
		consumers.add(thread);
		thread.start();
	}
}