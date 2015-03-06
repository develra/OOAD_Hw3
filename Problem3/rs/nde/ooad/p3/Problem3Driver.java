package rs.nde.ooad.p3;

public class Problem3Driver {
	public static void main(String[] args) {
		System.out.println("\nhtml:");
		Analysis.main(new String[]{"html"});

		System.out.println("\nxml:");
		Analysis.main(new String[]{"xml"});

		System.out.println("\ntext:");
		Analysis.main(new String[]{"text"});
	}
}
