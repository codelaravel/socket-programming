import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PostMessages implements Runnable{

	Socket connection;
	PrintStream input;
	String name, message;
	Scanner user;
	
	PostMessages(Socket connection, String name) throws IOException{
		this.connection = connection;
		this.name = name;
		input = new PrintStream(connection.getOutputStream());
		user = new Scanner(System.in);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(connection.isConnected()){
			message = user.nextLine();
			message = name + ": " + message;
			input.println(message);
		}
		
	}
	

}
