/**  
 * @Title: TestThrowAccurateValid02.java
 * @Prject: ECE654Project
 * @Package: throwAccurateValid
 * @Description: ECE 654 Project throw accurate and valid exception demo 02
 * @author: ruins7  
 * @date: Jun 28, 2016 10:27:08 PM
 * @version: V1.0  
 */
package throwaccuvalid;

/**
 * @ClassName: TestThrowAccurateValid02
 * @Description: full exception types in throws
 * @author: ruins7
 * @date: Jun 28, 2016 10:27:08 PM
 */
public class TestThrowAccurateValid02 {

	/**
	 * @Title: foo
	 * @Description: write full exception types in throws
	 * @param i
	 * @return: void
	 */
//	public static void foo(int i) throws Throwable{ 
	public static void foo(int i) throws Exception{ 
//	public static void foo(int i) throws Exception1{ 
//	public static void foo(int i) throws Exception1,Exception2,Exception3{
		if(i == 1){
			throw new Exception1();
		}
		if(i == 2){
			throw new Exception2();
		}
		if(i == 3){
			throw new Exception3();
		}
	}

	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
			try {
				foo(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}

/**
 * @ClassName: Exception1
 * @Description: example exception class
 * @author: ruins7
 * @date: Jun 28, 2016 10:27:08 PM
 */
class Exception1 extends Exception{
	
}

/**
 * @ClassName: Exception2
 * @Description: example exception class
 * @author: ruins7
 * @date: Jun 28, 2016 10:27:08 PM
 */
class Exception2 extends Exception1{
	
}

/**
 * @ClassName: Exception3
 * @Description: example exception class
 * @author: ruins7
 * @date: Jun 28, 2016 10:27:08 PM
 */
class Exception3 extends Exception2{
	
}
