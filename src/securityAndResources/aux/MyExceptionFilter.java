/**  
 * @Title: MyExceptionFilter.java
 * @Prject: ECE654Project
 * @Package: securityAndResources
 * @Description: ECE 654 Project security and resources demo 01 auxiliary
 * @author: ruins7  
 * @date: Jun 21, 2016 3:30:36 PM
 * @version: V1.0  
 */
package securityAndResources.aux;

/**
 * @ClassName: MyExceptionFilter
 * @Description: filter of exception for preventing leaking sensitive information
 * @author: ruins7
 * @date: Jun 21, 2016 3:30:36 PM
 */
public class MyExceptionFilter{
	
	/**
	 * @Title: exceptionFilter
	 * @Description: categorize exception and return a secure one
	 * @param t
	 * @return: Exception
	 */	
 public static Exception exceptionFilter(Throwable t){
	 if(t instanceof SensitiveException){
		 // too sensitive 
		 // you can return null or you can return default exception which is secure.
	    return null;
	 }else if (t instanceof InsensitiveException){
		 // not sensitive
 		 // return a default exception or return original exception type.  
		 return defaultException();
		 // return (Exception)t;
	 }
	 
	 //no match
	 return (Exception)t;
 	 }
 
   /**
	 * @Title: defaultException
	 * @Description: define a secure default type exception
	 * @param null
	 * @return: Exception
	 */	
   public static Exception defaultException(){
	   // you can modify default exception which is secure.
	   return new Exception();
   }
}
 
  /**
   * @ClassName: SensitiveException
   * @Description: define sensitive exception types
   * @author: ruins7
   * @date: Jun 21, 2016 3:30:36 PM
   */
  class SensitiveException extends Throwable{
	  //define SensitiveException
  }
  
  /**
   * @ClassName: InsensitiveException
   * @Description: define insensitive exception types
   * @author: ruins7
   * @date: Jun 21, 2016 3:30:36 PM
   */
  class InsensitiveException extends Throwable{
	  //define insensitiveException
  }
