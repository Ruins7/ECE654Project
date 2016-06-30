package objectAfterException.aux;

public class Account {

	private String accountName;
	private int amount;
	
	public Account(String accountName, int amount){
		this.accountName = accountName;
		this.amount = amount;
	}
	
	public void setAccountName(String accountName){
		this.accountName = accountName;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public String getAccountName(){
		return accountName;
	}
	
	public int getAmount(){
		return amount;
	}
}
