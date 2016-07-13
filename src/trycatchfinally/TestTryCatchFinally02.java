/**  
 * @Title: TestTryCatchFinally02.java
 * @Prject: ECE654Project
 * @Package: tryCatchFinally
 * @Description: ECE 654 project try catch finally demo 02
 * @author: ruins7  
 * @date: Jun 27, 2016 5:01:13 PM
 * @version: V1.0  
 */
package trycatchfinally;

/**
 * @ClassName: TestTryCatchFinally02
 * @Description: never return from try or finally block
 * @author: ruins7
 * @date: Jun 27, 2016 5:01:13 PM
 */
public class TestTryCatchFinally02 {

	/**
	 * @Title: returnInTry
	 * @Description: return from try block, method will not return,
	 *  it sequentially executes into finally block
	 * @param null
	 * @return: int
	 */
	public static int returnInTry(){
		try {
			System.out.println("now try is running...");
		    return 1;
		    //no exception occures, so catch block will not be execute,reture 1
		} catch(Exception e){
			System.out.println("now catch is running...");
			return 2;
		}
		 
	}
	
	/**
	 * @Title: returnInFinally
	 * @Description: return from finally block, 
	 * method may return a different status and suppresses exceptions 
	 * @param null
	 * @return: int
	 */
	public static int returnInFinally() {
		try {
			System.out.println("now try is running...");
			return 3;
		} catch(Exception e){
			return 4;
		} finally{
			//the same,catch block will not execute,but finally will, so return 5
			System.out.println("now fianlly is running...");
			return 5;
		}
		
	}
	
	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		 
				System.out.println(returnInTry());
				System.out.println(returnInFinally());
			 
	}

}
