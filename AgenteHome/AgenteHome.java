package AgenteHome;

import Roteamento.Roteamento;
import server.RMIServer;

public class AgenteHome {

	public RMIClient rmiClient = new RMIClient();
	public Roteamento roteamento = new Roteamento();
	public RMIServer rmiServer = new RMIServer();

	public void main(String args[]) {
		if (args[1] == "inicia") {
			rmiServer.iniciarServer();
		}
	}

	// Verifica se o ip existe no CoA enviado
	public Boolean verifica(String ip, String CoA) {
		return roteamento.validaIp(ip, CoA);
	}

	// Obter CoA a partir do IP enviado
	public String obtemCoA(String ip) {
		return roteamento.getCoAIp(ip);
	}

	// Encaminhar mensagem para o ForeignAgent
	public void encaminhaMensagem(String ip, String mensagem) {
		mobileNode = rmiClient.conectar(ip);
		mobileNode.receberMensagem(mensagem);
	}
}