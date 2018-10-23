package client;

import Correspondente.Correspondente;

public class Mensagem {

	public String coa = "0.0.0.0";
	public String ipDestinatario = "0.0.0.0";
	public String mensagem = "Alguma mensagem";
	Correspondente correspondente = new Correspondente();

	public void main(String args[]) throws RemoteException {
		correspondente.transmitirMensagem(coa, ipDestinatario, mensagem);
	}
}
