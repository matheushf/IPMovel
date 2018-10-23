package client;

import Correspondente.Correspondente;

public class Mensagem {

	Correspondente correspondente = new Correspondente();

	public void main(String args[]) throws RemoteException {
		String coa = "0.0.0.0";
		String ip = "0.0.0.0";
		String mensagem = "Alguma mensagem";

		correspondente.transmitirMensagem(coa, ip, mensagem);
	}
}