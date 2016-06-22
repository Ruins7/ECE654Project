/**  
 * @Title: TestSecurityAndResources02.java
 * @Prject: ECE654Project
 * @Package: securityAndResources
 * @Description: ECE 654 Project security and resources demo 02 
 * @author: ruins7  
 * @date: Jun 21, 2016 4:22:32 PM
 * @version: V1.0  
 */
package securityAndResources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName: TestSecurityAndResources02
 * @Description: close resources in finally and try-with-resources
 * @author: ruins7
 * @date: Jun 21, 2016 4:22:32 PM
 */
public class TestSecurityAndResources02 {

	
	/**
	 * @Title: cloResWithTWR
	 * @Description: use try-with-resource 
	 * @param null
	 * @return: void
	 * @throws: FileNotFoundException, IOException
	 */
	public static void cloResWithTWR() throws FileNotFoundException, IOException{
		 
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/ruins7/Desktop/1234.txt"))){
            System.out.println("123123123");     
          	//throw new IOException();
        } catch(Exception e) {
        	   System.err.println("error: " + e.getSuppressed().length);
        	   e.printStackTrace();
        	   Throwable[] supressed = e.getSuppressed();
        	   for (int i = 0; i < supressed.length; i++) {
				Throwable throwable = supressed[i];
				System.out.println("supressed exception: " + throwable.toString());
			}
        }
	}
	
	/**
	 * @Title: cloResWithFinally
	 * @Description: use finally 
	 * both try and finally throw exceptions when use finally, 
	 * only throw exception in finally,exception in try will be suppressed.  
	 * @param null
	 * @return: void
	 * @throws: FileNotFoundException, IOException
	 */
	public static void cloResWithFinally() throws FileNotFoundException, IOException{
		File file = new File("/Users/ruins7/desktop/1234.txt");
	    FileInputStream fis = null;
	    try {//fileNotFound
			fis = new FileInputStream(file);
			//other operation
		} finally {//IOEXception
			if(fis != null){
				fis.close();
			}
		    throw new IOException();
		}
	}
	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//cloResWithFinally();
		cloResWithTWR();
	}

}
