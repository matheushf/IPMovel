package NoMovel;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// import server.RMIServer;
import NoMovel.NoMovelConstant;
import NoMovel.NoMovelInterface;

public class NoMovel implements NoMovelInterface {

	// public RMIServer rmiServer = new RMIServer(NoMovelConstant.RMI_ID, NoMovelConstant.RMI_PORT);

	public void main(String[] args) {
		if (args[0] == "inicia") {
			// rmiServer.iniciarServer(NoMovelInterface);

			try {

				NoMovel noMovel = new NoMovel();
				NoMovelInterface server = (NoMovelInterface) UnicastRemoteObject.exportObject(noMovel, 0);

				Registry registry = LocateRegistry.createRegistry(NoMovelConstant.RMI_PORT);

				registry.bind(NoMovelConstant.RMI_ID, server);

				System.out.println("AgenteEstrangeiro ready!");

			} catch (Exception e) {
				System.err.println("Server exception: " + e.toString());
				e.printStackTrace();
			}
		}
	}

	public void receberMensagem(String mensagem) {
		System.out.println(mensagem);
	}
}
