
public class Test extends SecurityManager{

	 static boolean f;
	 
	public static void main(String[] args)  {
		java.lang.Compiler.disable();
		int i = 1;
		 for (int j = 0; i < 1000; j++) {
		     i++;	
		     System.out.println(i);
		}
		 java.lang.Compiler.enable();
}

	 
}
