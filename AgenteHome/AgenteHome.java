package AgenteHome;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Roteamento.Roteamento;
import client.Mensagem;
// import server.RMIServer;
// import client.RMIClient;
import AgenteHome.AgenteHomeInterface;
import AgenteHome.AgenteHomeConstant;
import NoMovel.NoMovelInterface;
import NoMovel.NoMovelConstant;

public class AgenteHome implements AgenteHomeInterface {

	public Roteamento roteamento = new Roteamento();
	public static Boolean server = true;

	public AgenteHome(Boolean server) {
		this.server = server ? server : false;
	}

	public static void main(String args[]) {
		if (server == true) {
			// rmiServer.iniciarServer(AgenteHomeInterface);

			try {
				AgenteHome agenteHome = new AgenteHome(false);
				AgenteHomeInterface server = (AgenteHomeInterface) UnicastRemoteObject.exportObject(agenteHome, 0);

				Registry registry = LocateRegistry.createRegistry(AgenteHomeConstant.RMI_PORT);

				registry.bind(AgenteHomeConstant.RMI_ID, server);

				System.out.println("AgenteHome ready!");

			} catch (Exception e) {
				System.err.println("Server exception: " + e.toString());
				e.printStackTrace();
			}
		}
	}

	// Verifica se o ip existe no CoA enviado
	public Boolean verifica(String ip, String coa) {
		return roteamento.validaIp(ip, coa);
	}

	// Obter CoA a partir do IP enviado
	public String obtemCoA(String ip) {
		return roteamento.getCoAIp(ip);
	}

	// Encaminhar mensagem para o ForeignAgent
	public void encaminhaMensagem(Mensagem mensagem) {
		// mobileNode = rmiClient.conectar(ip);
		// mobileNode.receberMensagem(mensagem);

		try {
			Registry registry = LocateRegistry.getRegistry(mensagem.ipDestinatario, NoMovelConstant.RMI_PORT);
			final NoMovelInterface noMovel = (NoMovelInterface) registry.lookup(NoMovelConstant.RMI_ID);          	  		

			System.out.println("NoMovel conectado no HA ");

			noMovel.receberMensagem(mensagem);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}		
	}
}