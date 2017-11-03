import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PostMessages implements Runnable {

	Socket connection;
	PrintStream input;
	String name, message1, message;
	Scanner user;

	PostMessages(Socket connection, String name) throws IOException {
		this.connection = connection;
		this.name = name;
		input = new PrintStream(connection.getOutputStream());
		user = new Scanner(System.in);
		message = "";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (connection.isConnected()) {
				message1 = user.nextLine();
				message = name + ": " + message1;
				input.println(message);

				if (message1.equals("over")) {
					connection.close();
				}
			}
		} catch (Exception e) {
			System.out.println("Conversation Ended!");
		}

	}
}
