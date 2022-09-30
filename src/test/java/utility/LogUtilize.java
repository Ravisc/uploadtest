package utility;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtilize {
		
		public static void logtest(){
	
	Logger logger=Logger.getLogger("LogUtilize");
		PropertyConfigurator.configure("log4j.properties");	
		
		
		}
	}

	


