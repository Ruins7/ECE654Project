/**  
 * @Title: TestTryCatchFinally03.java
 * @Prject: ECE654Project
 * @Package: tryCatchFinally
 * @Description: ECE 654 project try catch finally demo 03
 * @author: ruins7  
 * @date: Jun 27, 2016 6:11:58 PM
 * @version: V1.0  
 */
package tryCatchFinally;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName: TestTryCatchFinally03
 * @Description: unreachable catch block
 * @author: ruins7
 * @date: Jun 27, 2016 6:11:58 PM
 */
public class TestTryCatchFinally03 {

	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		File file = new File("/Users/ruins7/Desktop/123.txt");
		FileInputStream fis = null;
		 try {
			new FileInputStream(file);
		} catch (FileNotFoundException e) {
			//reachable
		} catch (IOException e2) {
			//compiler thinks it is reachable ,but it is unreachable
		}
		 
		 try {
			 new FileInputStream(file);
			 //both catches are reachable
		} catch (SecurityException | IOException e ) {
			 
		}  

	}

}
