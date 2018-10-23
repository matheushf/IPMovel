package client;

import Correspondente.Correspondente;

public class Mensagem {
	
	public String mensagem = "Alguma mensagem";

	Correspondente correspondente = new Correspondente();

	public void main(String args[]) throws RemoteException {
		correspondente.transmitirMensagem(mensagem);
	}
}
