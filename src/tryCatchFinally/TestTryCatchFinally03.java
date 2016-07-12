/**  
 * @Title: TestTryCatchFinally03.java
 * @Prject: ECE654Project
 * @Package: tryCatchFinally
 * @Description: ECE 654 project try catch finally demo 03
 * @author: ruins7  
 * @date: Jun 27, 2016 6:11:58 PM
 * @version: V1.0  
 */
package trycatchfinally;

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
		File file = new File("F:/GitHub/mylocalgithubrepository/ECE654Project/basicrule01.txt");
		FileInputStream fis = null;
		 try {
			new FileInputStream(file);
		} catch (FileNotFoundException e) {
			//reachable
		} catch (IOException e2) {
			//it is unreachable,should be removed
		}
		 
		 try {
			 new FileInputStream(file);
			 //both catches are reachable,and after JDK1.7, we can write more exception type in one catch
		} catch (SecurityException | IOException e ) {
			 
		}  

	}

}
