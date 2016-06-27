import java.io.IOException;

public class Test extends SecurityManager{

	 public static int m1(){
		 try {
				
			    throw new IOException();
			    
			} catch (Exception e) {
				return 2;
			} 
	 }
	 
	public static void main(String[] args)  {
		
			System.out.println(m1());
	 
}
}
