package entities;

import java.io.IOException;
import java.util.Scanner;

public class ServerSendingThread implements Runnable {

	Scanner scanner = new Scanner(System.in);
	String message;
	Server server;

	public ServerSendingThread(Server server) throws IOException {
		this.server = server;
	}

	@Override
	public void run() {
		try {
			while (true) {

				message = scanner.nextLine();
				if (message.equals("exit()"))
					break;

				server.SendMessage(message);

			}
			server.CloseChat();
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}