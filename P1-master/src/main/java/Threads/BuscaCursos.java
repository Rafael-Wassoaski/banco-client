package Threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BuscaCursos implements Runnable {

	
	private String menssagem;
	
	
	public BuscaCursos(String menssagem) {
		super();
		this.menssagem = menssagem;
	}


	public String getMenssagem() {
		return menssagem;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost", 5678);
			PrintWriter print = new PrintWriter(socket.getOutputStream(), true);
			print.println(menssagem);
			Scanner scanner = new Scanner(socket.getInputStream());
			
			while(true) {
				if(scanner.hasNext()) {
					menssagem = scanner.nextLine();
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}