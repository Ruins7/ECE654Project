/**  
 * @Title: TestSecurityAndResources01.java
 * @Prject: ECE654Project
 * @Package: securityAndResources
 * @Description: ECE 654 Project security and resources demo 01 
 * @author: ruins7  
 * @date: Jun 21, 2016 2:11:33 PM
 * @version: V1.0  
 */
package securityresources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import securityresources.auxclass.MyExceptionFilter;
import securityresources.auxclass.MySecurityManager;

/**
 * @ClassName: TestSecurityAndResources01
 * @Description: domo for sensitive information leak
 * @author: ruins7
 * @date: Jun 21, 2016 2:11:33 PM
 */
public class TestSecurityAndResources01 {
	
	private static Logger logger = LogManager.getLogger(TestSecurityAndResources01.class.getName());

	
	/**
	 * @Title: leakInformationAndType
	 * @Description: not recommend, it leaks exception content and type to attacker.
	 * @param null
	 * @return: void
	 */
	public static void leakInfoAndType(){
		File file = null;
		FileInputStream fis = null;
		try {
			//Windows:APPDATA, Linux : HOME, macOS: HOME
			file = new File(System.getenv("APPDATA"));
			fis = new FileInputStream(file);
			//other operation
		} catch (FileNotFoundException e) {
			//1. it will leak both exception content and type to user.
			e.printStackTrace();
			//2. warp original exception and throw a more general one.
			//it is still informative and unsafe. 
			throw new SecurityException("io exception");
			//Use log here.
		} finally {
			try {
				if(fis != null){
					fis.close();
				}
			} catch (IOException e2) {
				 System.err.println("file input stream closes fail!");
			}
		}
	}
	
	/**
	 * @Title: secureForSensitiveInfo
	 * @Description: secure way to prevent leaking sensitive information
	 *  validate input
	 *	use security policy
	 *	use exception filter
	 * @param null
	 * @return: void
	 */
	public static void secureForSensitiveInfo(){
		
		File file = null;
		try {
			//file = new File(System.getenv("HOME")).getCanonicalFile();
			file = new File("F:/GitHub/mylocalgithubrepository/ECE654Project/basicrule01.txt");
			//if(!file.getAbsolutePath().startsWith("/Users/ruins7")){
			// policy to restrict files only from indicated content
			if(!file.getAbsolutePath().startsWith("F:/GitHub/mylocalgithubrepository/ECE654Project/")){
				System.out.println("invalid file.");
				return;
			}
		} catch (Throwable e) {
			//sensitive exception information filter
			 MyExceptionFilter.exceptionFilter(e);
		}
	}
	
	/**
	 * @Title: main
	 * @Description: main method
	 * demo for do not terminate jvm abruptly.do necessary operation before exit system.
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args){
		//leakInfoAndType();
		secureForSensitiveInfo();
		
		//before terminate JVM, we could write a log at least to record why system would terminate.
		MySecurityManager msm = new MySecurityManager();
		System.setSecurityManager(msm);
		try {
			System.out.println("5");
			System.exit(1);
		} catch (Throwable t) {
			System.out.println("3");
			if(t instanceof SecurityException){
				System.out.println("6");
				logger.debug(" Security exception: Try to exit system");
				//other necessary operation.
			}else {
				System.out.println("7");
				logger.debug(" Not security exception: Try to exit system");
			}		
		}
		System.out.println("4");
		msm.setExitAllowed(true);
		System.exit(0);
	}

}
