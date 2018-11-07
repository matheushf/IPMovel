package client;

import Correspondente.Correspondente;

public class Mensagem {
	
	public String mensagem = "Alguma mensagem";
	public String ipRemetente = "0.0.0.0";
	public String ipDestinatario = "0.0.0.0";

	public Mensagem(String mensagem, String ipRemetente, String ipDestinatario) {
		this.mensagem = mensagem;
		this.ipRemetente = ipRemetente;
		this.ipDestinatario = ipDestinatario;
	}

	public void main(String args[]) {
	}	
}
