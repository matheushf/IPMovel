package Mensagem;

import Correspondente.Correspondente;
import java.io.Serializable;

public class MensagemControle implements Serializable {

	public String ip = "0.0.0.0";
	public String coa = "0.0.0.0";

	public MensagemControle(String ip, String coa) {
		this.coa = coa;
		this.ip = ip;
	}

	private static final long serialVersionUID = 90L;

	public void main(String args[]) {
	}
}
