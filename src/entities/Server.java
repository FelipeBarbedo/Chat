package entities;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private Socket socket;
	private ServerSocket serverSocket;
	private DataOutputStream outputMessage;
	private DataInputStream inputMessage;

	public Server(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		conectWithClient();
		this.outputMessage = new DataOutputStream(this.socket.getOutputStream());
		this.inputMessage = new DataInputStream(this.socket.getInputStream());

	}

	public void conectWithClient() throws IOException {
		this.socket = serverSocket.accept();
		System.out.println("Client " + socket.getInetAddress().getHostAddress() + " conected.");
	}

	public void SendMessage(String message) throws IOException {
		outputMessage.writeUTF(message);
	}

	public String ReceivedMessage() throws IOException {
		return inputMessage.readUTF();
	}

	public void CloseChat() throws IOException {
		outputMessage.close();
		inputMessage.close();
		socket.close();
		serverSocket.close();
	}

}
