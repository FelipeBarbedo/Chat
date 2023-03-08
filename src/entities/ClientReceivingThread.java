package entities;

import java.io.IOException;
import java.util.Scanner;

public class ClientReceivingThread implements Runnable {

	Scanner scanner = new Scanner(System.in);
	Client client;

	public ClientReceivingThread(Client client) throws IOException {
		this.client = client;
	}

	@Override
	public void run() {
		while (true) {

			try {
				System.out.println(client.ReceivedMessage());
			} catch (IOException e) {
				System.out.println("Connection interrupted.");
				break;
			}
		}

	}

}
