package view;

import java.util.concurrent.Semaphore;

import controller.cruzamento;

public class principal {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore farol = new Semaphore (permissao);
		
		for(int IdCarro = 0; IdCarro < 4; IdCarro ++) {
			Thread cruzamento = new cruzamento (IdCarro, farol);
			cruzamento.start();
		}

	}

}
