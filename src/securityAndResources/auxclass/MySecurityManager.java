/**  
 * @Title: MySecurityManager.java
 * @Prject: ECE654Project
 * @Package: securityAndResources.aux
 * @Description: ECE 654 Project security and resources demo 01 auxiliary
 * @author: ruins7  
 * @date: Jun 21, 2016 4:28:49 PM
 * @version: V1.0  
 */
package securityAndResources.auxclass;

/**
 * @ClassName: MySecurityManager
 * @Description: Security Manager
 * @author: ruins7
 * @date: Jun 21, 2016 4:28:49 PM
 */
public class MySecurityManager extends SecurityManager{

	private boolean isExitAllowedFlag;

	/**
	 * @Title:MySecurityManager
	 * @Description:TODO
	 */
	public MySecurityManager() {
		super();
		isExitAllowedFlag = false;
	}
	
	public boolean isExitAllowed(){
		return isExitAllowedFlag;
	}
	
	/** (non Javadoc)
	 * @Title: checkExit
	 * @Description: mandatory cleanup before exit
	 * @param status
	 * @see java.lang.SecurityManager#checkExit(int)
	 */
	@Override
	public void checkExit(int status) {
		System.out.println("1 "+isExitAllowedFlag+"  "+status);
		if(!isExitAllowed()){
			System.out.println("2 "+isExitAllowedFlag);
			throw new SecurityException();
		}
		super.checkExit(status);
	}
	
	public void setExitAllowed(boolean flag){
		isExitAllowedFlag = flag;
	}
	
	
	 
}
