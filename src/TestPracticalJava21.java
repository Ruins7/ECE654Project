import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestPracticalJava21 {
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(0);
		try {
			Socket socket = ss.accept();	
		} catch (IOException e) {
			ss.close();
		}
	}
}
