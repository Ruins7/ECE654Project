/**  
 * @Title: TestThrowAccurateValid01.java
 * @Prject: ECE654Project
 * @Package: throwAccurateValid
 * @Description: ECE 654 Project throw accurate and valid exception demo 01 
 * @author: ruins7  
 * @date: Jun 28, 2016 9:17:08 PM
 * @version: V1.0  
 */
package throwAccurateValid;

/**
 * @ClassName: TestThrowAccurateValid01
 * @Description: never catch NullPointerException, use null check instead or Null object model pattern
 * @author: ruins7
 * @date: Jun 28, 2016 9:17:08 PM
 */
public class TestThrowAccurateValid01{

	/**
	 * @Title: throwNull
	 * @Description: not recommend, catch NullPointerException
	 * @param str
	 * @return: int
	 */
	public static int throwNull(String str){
		try {
			return str.length();
		} catch (NullPointerException e) {
			return -1;
		}
	}
	
	/**
	 * @Title: nullCheck
	 * @Description: recommend, null check
	 * @param str
	 * @return: int
	 */
	public static int nullCheck(String str) {
		 if(str == null){
			 return -1; 
		 }
		return str.length();
	}
	
	 
	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		 String str = null;
		 System.out.println(throwNull(str));
		 System.out.println(nullCheck(str));
		 
	}


}

 