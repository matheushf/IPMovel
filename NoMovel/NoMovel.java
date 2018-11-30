package NoMovel;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import AgenteEstrangeiro.AgenteEstrangeiroConstant;
import AgenteEstrangeiro.AgenteEstrangeiroInterface;
// import server.RMIServer;
import NoMovel.NoMovelConstant;
import NoMovel.NoMovelInterface;
import Mensagem.Mensagem;

public class NoMovel implements NoMovelInterface {

	// public RMIServer rmiServer = new RMIServer(NoMovelConstant.RMI_ID,
	// NoMovelConstant.RMI_PORT);
	public static Boolean server = true;
	public static String coaEstrangeiro = "0.0.0.0";	
	public static String ipNoMovel = "0.0.0.0";	

	public NoMovel(Boolean server) {
		this.server = server ? server : false;
	}

	public static void main(String[] args) {
		if (server == true) {
			NoMovel noMovel = new NoMovel(false);
			noMovel.iniciaServer(noMovel);
			noMovel.avisarNoDisponivel(coaEstrangeiro, ipNoMovel);
		}
	}

	public void iniciaServer(NoMovel noMovel) {
		try {

			NoMovelInterface server = (NoMovelInterface) UnicastRemoteObject.exportObject(noMovel, 0);

			Registry registry = LocateRegistry.createRegistry(NoMovelConstant.RMI_PORT);

			registry.bind(NoMovelConstant.RMI_ID, server);

			System.out.println("No Movel ready!");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public void avisarNoDisponivel(String coa, String ip) {
		AgenteEstrangeiroInterface foreignAgent = null;

		try {
			Registry registry = LocateRegistry.getRegistry(coa, AgenteEstrangeiroConstant.RMI_PORT);
			foreignAgent = (AgenteEstrangeiroInterface) registry.lookup(AgenteEstrangeiroConstant.RMI_ID);

			System.out.println("AgenteEstrangeiro conectado, avisar que esta disponivel ");
			foreignAgent.reconhecimento(coa, ip);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();

		}
	}

	public void receberMensagem(Mensagem mensagem) throws RemoteException {
		System.out.println("No movel recebe msg: " + mensagem);
	}
}
