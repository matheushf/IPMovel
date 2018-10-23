package AgenteHome;

import Roteamento.Roteamento;
import server.RMIServer;
import AgenteHome.AgenteHomeInterface;
import AgenteHome.AgenteHomeConstant;
import NoMovel.NoMovelInterface;
import NoMovel.NoMovelConstant;

public class AgenteHome {

	public RMIClient rmiClient = new RMIClient(NoMovelConstant.RMI_ID, NoMovelConstant.RMI_PORT);
	public Roteamento roteamento = new Roteamento();
	public RMIServer rmiServer = new RMIServer(AgenteHomeConstant.RMI_ID, AgenteHomeConstant.RMI_PORT);

	public void main(String args[]) {
		if (args[1] == "inicia") {
			rmiServer.iniciarServer(AgenteHomeInterface);
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
		NoMovelInterface mobileNode = rmiClient.conectar(ip, NoMovelInterface);
		mobileNode.receberMensagem(mensagem);
	}
}