package AgenteEstrangeiro;

import Roteamento.Roteamento;
import client.RMIClient;

public class AgenteEstrangeiro {

	public RMIClient rmiClient = new RMIClient();
	public Roteamento roteamento = new Roteamento();

	public static void main(String args[]) {

	}

	// Obter CoA a partir do IP enviado
	public String obtemCoA(String ip) {

		return roteamento.getCoAIp(ip);
	}

	// Encaminhar mensagem para o No Movel
	public void encaminhaMensagem(String ip, String mensagem) {
		mobileNode = rmiClient.conectar(ip);
		mobileNode.receberMensagem(mensagem);
	}
}
