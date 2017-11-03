import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class GetMessages implements Runnable {

	Socket connection;
	Scanner input;
	String name, message;
	
	GetMessages(Socket connection) throws IOException{
		this.connection = connection;
		input = new Scanner(connection.getInputStream());
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(connection.isConnected()){
				message = input.nextLine();
				System.out.println(message);
			}
		}catch(Exception e){
			System.out.println("Conversation Ended!");
		}
		
	}
	
}
