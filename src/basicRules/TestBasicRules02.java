/**  
 * @Title: TestBasicRules02.java
 * @Prject: ECE654Project
 * @Package: basicRules
 * @Description: ECE 654 project basic rules demo 02
 * @author: ruins7  
 * @date: Jun 19, 2016 5:23:02 PM
 * @version: V1.0  
 */
package basicRules;

/**
 * @ClassName: TestBasicRules02
 * @Description:  do not use exception in control flow
 * @author: ruins7
 * @date: Jun 19, 2016 5:23:02 PM
 */
public class TestBasicRules02 {

	/**
	 * @Title: exceptionEndLoop
	 * @Description: example of using exception in control flow
	 * @param null
	 * @return: void
	 */
	public static void exceptionEndLoop(){
		int i = 1;
		try {
			while(true){//the condition is always true
			   System.out.println(i++);
			   if(i >= 100){
				   //create a new object means consume memory
				   throw new ArrayIndexOutOfBoundsException(); 
			   }
			}
		} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("loop ends");
		}
		
	}
	
	/**
	 * @Title: recommendEndLoop
	 * @Description:  example of using loop condition in control flow  
	 * @param args
	 * @return: void
	 */
	public static void recommendEndLoop(){
		int i = 1;
		while(i <= 100){//use condition to control
			System.out.println(i);
			i++;
		}
		System.out.println("loop ends");
	}
	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		recommendEndLoop();
		//exceptionEndLoop();
	}

}
