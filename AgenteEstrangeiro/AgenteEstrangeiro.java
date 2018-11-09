package AgenteEstrangeiro;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Roteamento.Roteamento;
import Mensagem.Mensagem;
import client.RMIClient;
// import server.RMIServer;
import AgenteEstrangeiro.AgenteEstrangeiroInterface;
import AgenteEstrangeiro.AgenteEstrangeiroConstant;
import NoMovel.NoMovelInterface;
import NoMovel.NoMovelConstant;

public class AgenteEstrangeiro implements AgenteEstrangeiroInterface {

	public Roteamento roteamento = new Roteamento();
	public static Boolean server = true;
	// public String coaEstrangeiro = "0.0.0.0";

	public AgenteEstrangeiro(Boolean server) {
		this.server = server ? server : false;
	}

	public void reconhecimento(String coa, String ip) {
		roteamento.mapearNoMovel(coa, ip);
	}

	public void main(String args[]) {
		if (server == true) {
			// rmiServer.iniciarServer(InterfaceAgenteEstrangeiro);

			try {

				AgenteEstrangeiro agenteEstrangeiro = new AgenteEstrangeiro(false);
				AgenteEstrangeiroInterface server = (AgenteEstrangeiroInterface) UnicastRemoteObject
						.exportObject(agenteEstrangeiro, 0);

				Registry registry = LocateRegistry.createRegistry(AgenteEstrangeiroConstant.RMI_PORT);

				registry.bind(AgenteEstrangeiroConstant.RMI_ID, server);

				System.out.println("AgenteEstrangeiro ready!");

			} catch (Exception e) {
				System.err.println("Server exception: " + e.toString());
				e.printStackTrace();
			}
		}
	}

	// Encaminhar mensagem para o No Movel
	public void encaminhaMensagem(Mensagem mensagem) {

		try {
			Registry registry = LocateRegistry.getRegistry(mensagem.ipDestinatario, NoMovelConstant.RMI_PORT);
			final NoMovelInterface noMovel = (NoMovelInterface) registry.lookup(NoMovelConstant.RMI_ID);

			noMovel.receberMensagem(mensagem);

			System.out.println("NoMovel conectado no FA ");

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
