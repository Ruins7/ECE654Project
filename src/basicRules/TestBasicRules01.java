/**  
 * @Title: TestBasicRules01.java
 * @Prject: ECE654Project
 * @Package: basicRules
 * @Description: ECE 654 project basic rules demo 01
 * @author: ruins7  
 * @date: Jun 19, 2016 2:48:23 PM
 * @version: V1.0  
 */
package basicRules;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: TestBasicRules01
 * @Description: catch and handle the exception or throw it to caller,do not ignore it. 
 * @author: ruins7
 * @date: Jun 19, 2016 2:48:23 PM
 */
public class TestBasicRules01 {

	private static Logger logger = LogManager.getLogger(TestBasicRules01.class.getName());

	/**
	 * @Title: input
	 * @Description: use FileInputStream to input a file 
	 * @param filename
	 * @return: void
	 */
	public static void input(String filename) {
		  
		 File file = new File(filename);
		 FileInputStream fis = null;
		 try {
			fis = new FileInputStream(file);
			while(fis.read() != -1){
				System.out.println(fis.read());
			}
		 } catch (IOException e) {//catch and handle it or throw it to caller
			 // if you catch it, do not do nothing !
			 //method 01:  user interact
			 System.err.println("file does not exist! please input correct file path and name!");
			 //method 02:  print error information(not secure,but helpful for debug)
			 //e.printStackTrace();
			 //method 03:  write a error log (Log4j)
			 logException(e, file);
		 } finally {
			try {
				fis.close();
				//throw new IOException();
			} catch (IOException e) {
				 //user interact
				 System.err.println("file input stream closes fail!");
				 // print error information
				 //e.printStackTrace();
				 // write a error log
				 logException(e, fis);
			}
		}
	}
	
	/**
	 * @Title: logException
	 * @Description: write exception log (Log4j 2)
	 * @param e, who
	 * @return: void
	 */
	public static void logException(IOException e, Object who){
		 logger.debug(who.getClass() + " -- " + e.getMessage());
	}
	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args){
		    System.out.println("Please input a file path and name:");
		    Scanner scanner = new Scanner(System.in);
		    String filepath = scanner.next();
			input(filepath);
			scanner.close();
	}
}
