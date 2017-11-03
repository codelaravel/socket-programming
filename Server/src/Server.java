import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{

	public static void main(String[] args) throws IOException{
		
		ServerSocket serversocket = new ServerSocket(4332);
		System.out.println("Server Started");
		Socket socket = serversocket.accept();
		System.out.println("Connected to" + socket.getInetAddress());
		Thread getMessage = new Thread(new GetMessages(socket));
		Thread postMesage = new Thread(new PostMessages(socket, "Server"));
		getMessage.start();
		postMesage.start();
		
		
	}
}
