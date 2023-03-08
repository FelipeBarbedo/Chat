package entities;

import java.io.IOException;
import java.util.Scanner;

public class ServerReceivingThread implements Runnable {

	Scanner scanner = new Scanner(System.in);
	Server server;

	public ServerReceivingThread(Server server) throws IOException {
		this.server = server;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(server.ReceivedMessage());
			} catch (IOException e) {
				System.out.println("Connection interrupted.");
				break;
			}
		}
	}
}
