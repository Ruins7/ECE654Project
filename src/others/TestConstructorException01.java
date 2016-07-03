/**  
 * @Title: TestConstructorException.java
 * @Prject: ECE654Project
 * @Package: others
 * @Description: ECE 654 Project other best practice demo 01
 * @author: ruins7  
 * @date: Jul 3, 2016 1:22:29 PM
 * @version: V1.0  
 */
package others;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName: TestConstructorException
 * @Description: throw exceptions in constructor
 * @author: ruins7
 * @date: Jul 3, 2016 1:22:29 PM
 */
public class TestConstructorException01 {

	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		Foo f = null;//only after constructor executes successfully, the object will be built.
		try {
			f = new Foo("");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e2) {
			System.out.println("IOException");
		}
	}

}

/**
 * @ClassName: Foo
 * @Description: class with constructor
 * @author: ruins7
 * @date: Jul 3, 2016 1:22:29 PM
 */
class Foo{
	public Foo(String filename) throws FileNotFoundException, IOException{
		FileReader fr = new FileReader(filename);//may not found
		BufferedReader br = new BufferedReader(fr);//may create IOexception
		//throw new IOException();
		//other operations
	}
	
}
