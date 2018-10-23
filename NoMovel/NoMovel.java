package NoMovel;

import server.RMIServer;
import NoMovel.NoMovelConstant;
import NoMovel.NoMovelInterface;

public class NoMovel {

	public RMIServer rmiServer = new RMIServer(NoMovelConstant.RMI_ID, NoMovelConstant.RMI_PORT);

	public void main(String[] args) {
		if (args[1] == "inicia") {
			rmiServer.iniciarServer(NoMovelInterface);
		}
	}

	public void receberMensagem(String mensagem) {
		System.out.println(mensagem);
	}
}