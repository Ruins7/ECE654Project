/**  
 * @Title: TestSecurityAndResoureces03.java
 * @Prject: ECE654Project
 * @Package: securityAndResources
 * @Description: ECE 654 project security and resources demo 03
 * @author: ruins7  
 * @date: Jun 22, 2016 3:29:00 PM
 * @version: V1.0  
 */
package securityresources;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: TestSecurityAndResoureces03
 * @Description: dome prevent exceptions while logging.
 * @author: ruins7
 * @date: Jun 22, 2016 3:29:00 PM
 */
public class TestSecurityAndResources03 {

	private static Logger logger = LogManager.getLogger(TestSecurityAndResources03.class.getName());
	
	/**
	 * @Title: standardError
	 * @Description: prevent use standard error stream to print error information.
	 * @param null
	 * @return: void
	 */
	public void standardError(){
		try {
			throw new IOException();
		} catch (Exception e) {
			 System.err.println(e);
			 System.out.println(e);
			 e.printStackTrace();
		}
	}
	
	/**
	 * @Title: loggerException
	 * @Description: demo it is possible to lose exception information when another exception occurs while logging.
	 * @param null
	 * @return: void
	 */
	public void loggerException(){
		try {
			throw new IOException();
		} catch (Exception e) {
			//simulate there are 10 exceptions messages need to be written in log.
			for (int i = 0; i < 10; i++) {
				 logger.debug(e.getStackTrace());
				 //while logging, a new exception occurs and it interrupts the logging
				 //in this case, we may lost security exception messages.
				 if(i == 5){
					try {
						throw new FileNotFoundException();
					} catch (IOException e1) { 
						System.exit(1);
					}
				 }
			}
			
		}
	}
	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		TestSecurityAndResources03 tsar = new TestSecurityAndResources03();
			//	tsar.standardError();
				tsar.loggerException();
		
	}

}
