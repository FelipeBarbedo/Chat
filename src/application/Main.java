package application;

import java.io.IOException;

import entities.Client;
import entities.ClientReceivingThread;
import entities.ClientSendingThread;

public class Main {

	public static void main(String[] args) throws IOException {

		// Server ip.
		Client client = new Client("000.000.0.0", 47311);

		Thread exe1 = new Thread(new ClientReceivingThread(client), "Receiving");
		Thread exe2 = new Thread(new ClientSendingThread(client), "Sending");

		exe1.start();
		exe2.start();

		/*
		 * Server server = new Server(47311);
		 * 
		 * Thread exe1 = new Thread(new ServerReceivingThread(server),
		 * "ServerReceving"); Thread exe2 = new Thread(new ServerSendingThread(server),
		 * "ServerSending");
		 * 
		 * exe1.start(); exe2.start();
		 * 
		 */

		// String message;
		// Scanner scanner = new Scanner(System.in);

		// Ip1 = | Port = 47312
		// Ip2 = | Port = 47311
		// Client client = new Client("", 47311);

		// while (true) {
		// message = scanner.nextLine();

		// if (message.equals("exit()"))
		// break;

		// client.SendMessage(message);
		// System.out.println(client.ReceivedMessage());

		// }

		// client.CloseChat();
		// server.CloseChat();
		// scanner.close();

	}
}
