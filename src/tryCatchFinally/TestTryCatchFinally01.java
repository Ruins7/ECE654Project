/**  
 * @Title: TestTryCatchFinally01.java
 * @Prject: ECE654Project
 * @Package: tryCatchFinally
 * @Description: ECE 654 project try catch finally demo 01
 * @author: ruins7  
 * @date: Jun 27, 2016 3:49:31 PM
 * @version: V1.0  
 */
package tryCatchFinally;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: TestTryCatchFinally01
 * @Description: test for try-catch block with loop
 * @author: ruins7
 * @date: Jun 27, 2016 3:49:31 PM
 */
public class TestTryCatchFinally01 {

	/**
	 * @Title: withinLoop
	 * @Description: not recommend, it causes bad performance.
	 * @param loopNumber
	 * @return: long
	 */
	public static long withinLoop(int loopNumber){
		long startTime = System.nanoTime();
		for (int i = 0; i < loopNumber; i++) {
			try {
				File file = new File("/Users/ruins7/Desktop/abc.txt");
				if(!file.exists()){
					file.createNewFile();
				} else if(file.exists()){
					file.delete();
				}
				if(i == loopNumber){
					throw new IOException();
				}
			} catch (Exception e) {
				//handle operation
			}
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	/**
	 * @Title: outOfLoop
	 * @Description: recommend, it is much batter than withinLoop
	 * @param loopNumber
	 * @return: long
	 */
	public static long outOfLoop(int loopNumber) {
		long startTime = System.nanoTime();
		try {
			for (int i = 0; i < loopNumber; i++) {
				File file = new File("/Users/ruins7/Desktop/abc.txt");
				if(!file.exists()){
					file.createNewFile();
				} else if(file.exists()){
					file.delete();
				}
				if(i == loopNumber){
					throw new IOException();
				}
			}
		}  catch (Exception e) {
			//handle operation
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		int loopNumber = 50000;
		System.out.println("milliseconds that put try-catch in loop: "+ withinLoop(loopNumber));
		System.out.println("milliseconds that put try-catch out of loop: "+ outOfLoop(loopNumber));
	}

}
