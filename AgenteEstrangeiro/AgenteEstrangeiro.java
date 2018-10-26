package AgenteEstrangeiro;

import Roteamento.Roteamento;
import client.RMIClient;
import server.RMIServer;
import AgenteEstrangeiro.AgenteEstrangeiroInterface;
import AgenteEstrangeiro.AgenteEstrangeiroConstant;
import NoMovel.NoMovelInterface;
import NoMovel.NoMovelConstant;

public class AgenteEstrangeiro {

	public RMIClient rmiClient = new RMIClient(NoMovelConstant.RMI_ID, NoMovelConstant.RMI_PORT);
	public Roteamento roteamento = new Roteamento();
	public RMIServer rmiServer = new RMIServer(AgenteEstrangeiroConstant.RMI_ID, AgenteEstrangeiroConstant.RMI_PORT);

	public void main(String args[]) {
		if (args[0] == "inicia") {
			rmiServer.iniciarServer(InterfaceAgenteEstrangeiro);
		}
	}

	// Obter CoA a partir do IP enviado
	public String obtemCoA(String ip) {
		return roteamento.getCoAIp(ip);
	}

	// Encaminhar mensagem para o No Movel
	public void encaminhaMensagem(String ip, String mensagem) {
		NoMovelInterface mobileNode = rmiClient.conectar(ip, NoMovelInterface);
		mobileNode.receberMensagem(mensagem);
	}
}
