
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestERR01 {

	 public static void main(String[] args) throws FileNotFoundException {
		    // Linux stores a in
		    // the environment variable $HOME, Windows in %APPDATA%
		    FileInputStream fis =
		        new FileInputStream(System.getenv("HOME") + args[0]); 
		    System.out.println(fis);
		  }
}
