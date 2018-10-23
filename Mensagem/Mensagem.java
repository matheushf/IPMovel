package client;

import Correspondente.Correspondente;

public class Mensagem {
	
	public String mensagem = "Alguma mensagem";

	Correspondente correspondente = new Correspondente();

	public void main(String args[]) {
		correspondente.transmitirMensagem(mensagem);
	}
}
