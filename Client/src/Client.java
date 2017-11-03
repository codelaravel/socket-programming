import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client  {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket connection = new Socket("localhost", 4332);
		Thread getMessage = new Thread(new GetMessages(connection));
		Thread postMessage = new Thread(new PostMessages(connection, "Shuvro"));
		getMessage.start();
		postMessage.start();
		
		
	}
}

