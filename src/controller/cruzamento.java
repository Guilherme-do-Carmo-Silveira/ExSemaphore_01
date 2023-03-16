package controller;

import java.util.concurrent.Semaphore;

public class cruzamento extends Thread {

	private int IdCarro;
	private Semaphore farol;
	
	public cruzamento(int IdCarro, Semaphore farol) {
		this.IdCarro = IdCarro;
		this.farol = farol;
	}
	
	
	public void run() {
		CarroAndando();
		try {
			farol.acquire();
			FarolAberto();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			farol.release();
		}

	}



	private void CarroAndando() {
		int distancia = 100;
		int distanciatotal = 0;
		int velocidade = 0;
		
		while(distanciatotal < distancia) {
			velocidade = (int) (Math.random() * 19) + 1;
			distanciatotal += velocidade;
			try {
				sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		System.out.println("O carro " + IdCarro  + " Chegou no farol");
	}


	private void FarolAberto() {
		int direçao;
		direçao = (int) (Math.random() * 4);
		if(direçao == 0) {
			System.out.println("O carro " + IdCarro + " atravessou de norte para sul");
		}else {
			if(direçao == 1) {
				System.out.println("O carro " + IdCarro + " atravessou de sul para norte");
			}else {
				if(direçao == 2) {
					System.out.println("O carro " + IdCarro + " atravessou de leste para oeste");
				}else {
					if(direçao == 3) {
						System.out.println("O carro " + IdCarro + " atravessou de oeste para leste");
					}
				}
			}
		}
	}
}
