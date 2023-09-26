package controller;

import java.util.concurrent.Semaphore;

public class ThreadOvercooked extends Thread{
	
	public int id;
	public Semaphore entrega;

	public ThreadOvercooked(int id, Semaphore entrega) {
		this.id = id;
		this.entrega = entrega;
	}
	
	public void run() {
		if (id%2 == 0) {
			lasanha();
		}
		else {
			sopaCebola();
		}
	}
	
	private void lasanha() {
		long tempoMax = (long)((Math.random()*601)+600);
		System.out.println("Prato #"+id+" => Lasanha a bolonhesa começou a cozinhar");
		long tempo = 0;
		while (tempo<tempoMax) {
			try {
				float perc = ((float)tempo / (float)tempoMax)*100;
				System.out.printf("Prato #"+id+" => %.1f %% pronto %n", perc);
				sleep(100);
				tempo = tempo+100;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			entrega.acquire();
			entrega();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entrega.release();
		}
		
	}

	private void sopaCebola() {
		long tempoMax = (long)((Math.random()*301)+500);
		System.out.println("Prato #"+id+" => Sopa de cebola começou a cozinhar");
		long tempo = 0;
		while (tempo<tempoMax) {
			try {
				float perc = ((float)tempo / (float)tempoMax)*100;
				System.out.printf("Prato #"+id+" => %.1f %% pronto %n", perc);
				sleep(100);
				tempo = tempo+100;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			entrega.acquire();
			entrega();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entrega.release();
		}
		
	}

	private void entrega() {
		try {
			sleep(500);
			if (id%2==0) {
				System.out.println("Prato #"+id+" => Lasanha a bolonhesa entregue");
			}
			else {
				System.out.println("Prato #"+id+" => Sopa de cebola entregue");
			}
		} catch (Exception e) {
			
		}
	}
	
}
