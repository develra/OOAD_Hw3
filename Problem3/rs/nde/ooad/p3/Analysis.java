package rs.nde.ooad.p3;

interface Logging
{
	public enum LOG_TYPE {TXT, XML, HTML};
	public void log(String msg);
}

class LogText implements Logging
{
	public LogText()
	{
		System.out.println("Logging: text format");
	}
	public void log(String msg)
	{	
		System.out.println("Logging text to file: " + msg);
	}
}
class LogXML implements Logging
{
	public LogXML()
	{
		System.out.println("Logging: <type>XML Format</type>");
	}
	public void log(String msg)
	{	
		System.out.println("Logging text to file: log.xml" );
		System.out.println("<xml><msg>"+msg+"</msg></xml>");
	}
}

class LogHTML implements Logging
{
	public LogHTML()
	{
		System.out.println("Logging: HTML format");
	}
	public void log(String msg)
	{	
		System.out.println("Logging HTML to file: log.html" );
		System.out.println("<html><body>"+msg+"</body></html>");
	}
}

class Analysis
{
	private static LoggingFactory Loggingfactory;
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java Analysis type");
			System.exit(-1);
		}
		String type = args[0];
		Loggingfactory = new LoggingFactory();
		Logging logfile = Loggingfactory.createLog(type);
		
		logfile.log("Starting application...");
		logfile.log("INFO: Important message!");
		logfile.log("Exiting. Exit code 0");
	}
}