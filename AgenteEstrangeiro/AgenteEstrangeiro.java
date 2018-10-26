package AgenteEstrangeiro;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Roteamento.Roteamento;
import client.RMIClient;
// import server.RMIServer;
import AgenteEstrangeiro.AgenteEstrangeiroInterface;
import AgenteEstrangeiro.AgenteEstrangeiroConstant;
import NoMovel.NoMovelInterface;
import NoMovel.NoMovelConstant;

public class AgenteEstrangeiro implements AgenteEstrangeiroInterface {

	public RMIClient rmiClient = new RMIClient(NoMovelConstant.RMI_ID, NoMovelConstant.RMI_PORT);
	public Roteamento roteamento = new Roteamento();
	// public RMIServer rmiServer = new RMIServer(AgenteEstrangeiroConstant.RMI_ID, AgenteEstrangeiroConstant.RMI_PORT);

	public void main(String args[]) {
		if (args[0] == "inicia") {
			// rmiServer.iniciarServer(InterfaceAgenteEstrangeiro);

			try {

				AgenteEstrangeiro agenteEstrangeiro = new AgenteEstrangeiro();
				AgenteEstrangeiroInterface server = (AgenteEstrangeiroInterface) UnicastRemoteObject.exportObject(agenteEstrangeiro, 0);

				Registry registry = LocateRegistry.createRegistry(AgenteEstrangeiroConstant.RMI_PORT);

				registry.bind(AgenteEstrangeiroConstant.RMI_ID, server);

				System.out.println("AgenteEstrangeiro ready!");

			} catch (Exception e) {
				System.err.println("Server exception: " + e.toString());
				e.printStackTrace();
			}
		}
	}

	// Obter CoA a partir do IP enviado
	public String obtemCoA(String ip) {
		return roteamento.getCoAIp(ip);
	}

	// Encaminhar mensagem para o No Movel
	public void encaminhaMensagem(String ip, String mensagem) {
		// noMovel = rmiClient.conectar(ip);
		// noMovel.receberMensagem(mensagem);

		try {
			Registry registry = LocateRegistry.getRegistry(ip, NoMovelConstant.RMI_PORT);
			final NoMovelInterface noMovel = (NoMovelInterface) registry.lookup(NoMovelConstant.RMI_ID);          	  		

			noMovel.receberMensagem(mensagem);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}		
	}
}
