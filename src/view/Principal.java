package view;

import java.util.concurrent.Semaphore;

import controller.ThreadOvercooked;

public class Principal {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore entrega = new Semaphore(permissao);
		for (int id = 1; id<=5;id++) {
			Thread thread = new ThreadOvercooked(id, entrega);
			thread.start();
		}

	}

}
