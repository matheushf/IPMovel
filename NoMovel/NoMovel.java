package NoMovel;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// import server.RMIServer;
import NoMovel.NoMovelConstant;
import NoMovel.NoMovelInterface;
import Mensagem.Mensagem;

public class NoMovel implements NoMovelInterface {

	// public RMIServer rmiServer = new RMIServer(NoMovelConstant.RMI_ID, NoMovelConstant.RMI_PORT);
	public static Boolean server = true;

	public NoMovel(Boolean server) {
		this.server = server ? server : false;
	}

	public static void main(String[] args) {
		if (server == true) {
			// rmiServer.iniciarServer(NoMovelInterface);

			try {

				NoMovel noMovel = new NoMovel(false);
				NoMovelInterface server = (NoMovelInterface) UnicastRemoteObject.exportObject(noMovel, 0);

				Registry registry = LocateRegistry.createRegistry(NoMovelConstant.RMI_PORT);

				registry.bind(NoMovelConstant.RMI_ID, server);

				System.out.println("No Movel ready!");

			} catch (Exception e) {
				System.err.println("Server exception: " + e.toString());
				e.printStackTrace();
			}
		}
	}

	public void receberMensagem(Mensagem mensagem) throws RemoteException {
		System.out.println("No movel recebe msg: " + mensagem);
	}
}
