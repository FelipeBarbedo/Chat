package entities;

import java.io.IOException;
import java.util.Scanner;

public class ClientSendingThread implements Runnable {

	Scanner scanner = new Scanner(System.in);
	String message;
	Client client;

	public ClientSendingThread(Client client) throws IOException {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			while (true) {

				message = scanner.nextLine();
				if (message.equals("exit()"))
					break;

				client.SendMessage(message);

			}
			client.CloseChat();
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
