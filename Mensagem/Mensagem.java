package Mensagem;

import Correspondente.Correspondente;
import java.io.Serializable;

public class Mensagem implements Serializable {
	
	public String mensagem = "Alguma mensagem";
	// Meu ip
	public String ipRemetente = "0.0.0.0";
	// Ip do no que vai receber
	public String ipDestinatario = "0.0.0.0";
	// Ip do home agente inicial
	public String coa = "0.0.0.0";

	public Mensagem(String mensagem, String ipRemetente, String ipDestinatario, String coa) {
		this.mensagem = mensagem;
		this.ipRemetente = ipRemetente;
		this.ipDestinatario = ipDestinatario;
		this.coa = coa;
	}
        
        private static final long serialVersionUID = 90L;

	public void main(String args[]) {
	}	
}
