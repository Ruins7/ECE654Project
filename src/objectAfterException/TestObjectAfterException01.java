/**  
 * @Title: TestObjectAfterException.java
 * @Prject: ECE654Project
 * @Package: objectAfterException
 * @Description: ECE 654 Project Object state after exception demo 01 
 * @author: ruins7  
 * @date: Jun 29, 2016 10:18:09 PM
 * @version: V1.0  
 */
package objectAfterException;

import objectAfterException.aux.Account;

/**
 * @ClassName: TestObjectAfterException
 * @Description: demo for recover object state after exception
 * @author: ruins7
 * @date: Jun 29, 2016 10:18:09 PM
 */
public class TestObjectAfterException01 {

	/**
	 * @Title: transferWithNoRollback
	 * @Description: not recommend, some operation which is successful did not change back after exception.
	 * @param accountTo, accountFrom, amount
	 * @return: int
	 */
	public static int transferWithNoRollback(Account accountTo, Account accountFrom, int amount){
		if(accountFrom.getAmount() - amount < 0){
			return -1;
		}
		try {
			accountTo.setAmount(accountTo.getAmount() + amount);
			accountFrom.setAmount(accountFrom.getAmount() - amount);
			//an exception occures here.
			if(accountFrom.getAmount() <= 10){
				accountFrom.setAmount(accountFrom.getAmount() + amount);
				throw new Exception();
			}
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	
	/**
	 * @Title: transferWithRollback
	 * @Description: recommend, some operation which is successful should change back after exception.
	 * @param accountTo, accountFrom, amount
	 * @return: int
	 */
	public static int transferWithRollback(Account accountTo, Account accountFrom, int amount){
		if(accountFrom.getAmount() - amount < 0){
			return -1;
		}
		try {
			accountTo.setAmount(accountTo.getAmount() + amount);
			accountFrom.setAmount(accountFrom.getAmount() - amount);
			//an exception occures here.
			if(accountFrom.getAmount() <= 10){
				accountFrom.setAmount(accountFrom.getAmount() + amount);
				throw new Exception();
			}
		} catch (Exception e) {
			//rollback here, recover the original objects' state
			accountTo.setAmount(accountTo.getAmount() - amount);
			return 0;
		} 
		return 1;
	}
	
	
	/**
	 * @Title: main
	 * @Description: main method
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		Account accountFrom = new Account("freddy", 119);
		Account accountTo = new Account("jasmine", 1000);
		int flag = transferWithRollback(accountTo, accountFrom, 100);
		System.out.println("balance in accountFrom: " + accountFrom.getAmount());
		System.out.println("balance in accountTo  : " + accountTo.getAmount());
		if(flag == -1){
			System.out.println(accountFrom.getAccountName()+ ": not enough money in your account.");
		}else if(flag == 1){
			System.out.println(accountFrom.getAccountName()+ ": transfer is successful.");
		}else if(flag == 0){
			System.out.println(accountFrom.getAccountName()+ ": low balance in your account, transction has been cancelled.");

		}
		
	}

}
