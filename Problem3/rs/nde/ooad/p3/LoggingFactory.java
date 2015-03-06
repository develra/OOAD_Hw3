package rs.nde.ooad.p3;

public class LoggingFactory {
		public Logging createLog(String type) {
			Logging logfile = null;
			
		if (type.equalsIgnoreCase("text"))
			logfile = new LogText();
		else if (type.equalsIgnoreCase("xml"))
			logfile = new LogXML();
		else if (type.equalsIgnoreCase("html"))
			logfile = new LogHTML();
		else
			logfile = new LogText();
		return logfile;
		}
	}
