package NoMovel;

import server.RMIServer;

public class NoMovel {

	public RMIServer rmiServer = new RMIServer();

	public void main(String[] args) {
		rmiServer.iniciarServer();
	}

	public void receberMensagem(String mensagem) {
		System.out.println(mensagem);
	}
}