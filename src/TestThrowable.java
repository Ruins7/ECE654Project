import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestThrowable {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String filename = "/Users/ruins7/Desktop/12345.txt";
		File newf = new File(filename);
		FileInputStream fst = null;
		try {
			if(!newf.exists()){
				newf.createNewFile();
			}
			//@SuppressWarnings("resource")//tell IED not to warning
			 fst = new FileInputStream(newf);
			 byte[] b = new byte[1024];
			 
			 while(fst.read() != -1){
				 System.out.println(fst.read(b));
			 }
				
			 
		} catch (Throwable e) {
			System.out.println("Throwable");
			e.printStackTrace();
		} finally {
			try {
				fst.close();
			} catch (IOException e) {
				 e.printStackTrace();
			}
			
		}
		
	}

}
