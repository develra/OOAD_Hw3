package rs.nde.ooad.p2;

import java.util.ArrayList;
import java.util.List;

public class Problem2Driver {
	private static List<Report> reports;
	public static void main(String[] args) {
		reports = new ArrayList<Report>();
		Submission submission = new Submission();
		
		reports.add(new PassFailReport(submission));
		reports.add(new TimeoutReport(submission));

		for (int i = 0; i < 1000; i++) {
			submission.runTestCase();
		}
		
		printReports();
	}
	
	private static void printReports() {
		for (Report report : reports) {
			System.out.println(report.getReport());
		}
	}
}