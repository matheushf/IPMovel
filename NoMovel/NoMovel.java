package NoMovel;

import server.RMIServer;

public class NoMovel {

	public RMIServer rmiServer = new RMIServer();

	public void main(String[] args) {
		if (args[1] == "inicia") {
			rmiServer.iniciarServer();
		}
	}

	public void receberMensagem(String mensagem) {
		System.out.println(mensagem);
	}
}