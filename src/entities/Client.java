package entities;

import java.io.*;
import java.net.Socket;

public class Client {

	private Socket socket;
	private DataOutputStream outputMessage;
	private DataInputStream inputMessage;

	public Client(String hostIp, int port) throws IOException {
		this.socket = new Socket(hostIp, port);
		System.out.println("Connection with " + hostIp + " establised successfully.");
		this.outputMessage = new DataOutputStream(this.socket.getOutputStream());
		this.inputMessage = new DataInputStream(this.socket.getInputStream());
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
	}

}