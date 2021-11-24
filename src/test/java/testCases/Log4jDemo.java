package testCases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;




public class Log4jDemo 
{
	
	
	Logger log = LogManager.getLogger(Log4jDemo.class);
	
	
	@Test
	public void test()
	{
		log.trace("Hello");
		
		log.info("This is info");
		log.error("Error");
		log.fatal("Fatal");
		log.debug("Debug");
		log.warn("Warn");
		
	}

}
