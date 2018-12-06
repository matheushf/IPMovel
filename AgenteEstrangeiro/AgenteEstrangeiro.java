package AgenteEstrangeiro;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Roteamento.Roteamento;
import Mensagem.Mensagem;
import Mensagem.MensagemControle;
import client.RMIClient;
// import server.RMIServer;
import AgenteEstrangeiro.AgenteEstrangeiroInterface;
import AgenteHome.AgenteHomeConstant;
import AgenteHome.AgenteHomeInterface;
import AgenteEstrangeiro.AgenteEstrangeiroConstant;
import NoMovel.NoMovelInterface;
import NoMovel.NoMovelConstant;

public class AgenteEstrangeiro implements AgenteEstrangeiroInterface {

	public Roteamento roteamento = new Roteamento();
	public static Boolean server = true;
	public static String coaFA = "0.0.0.0";
	public static String coaHome = "0.0.0.0";

	public AgenteEstrangeiro(Boolean server) {
		this.server = server ? server : false;
	}

	public static void main(String args[]) {
		if (server == true) {
			AgenteEstrangeiro agenteEstrangeiro = new AgenteEstrangeiro(false);
			agenteEstrangeiro.iniciaServer(agenteEstrangeiro);

			MensagemControle mensagemControle = new MensagemControle(coaFA, "0.0.0.0");
			agenteEstrangeiro.avisarAgenteHome(mensagemControle);
		}
	}

	public void iniciaServer(AgenteEstrangeiro agenteEstrangeiro) {
		try {
			AgenteEstrangeiroInterface server = (AgenteEstrangeiroInterface) UnicastRemoteObject
					.exportObject(agenteEstrangeiro, 0);

			Registry registry = LocateRegistry.createRegistry(AgenteEstrangeiroConstant.RMI_PORT);

			registry.bind(AgenteEstrangeiroConstant.RMI_ID, server);

			System.out.println("AgenteEstrangeiro ready! " + coaFA);

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public void reconhecimento(MensagemControle mensagemControle) {
		roteamento.mapearNoMovel(mensagemControle.coa, mensagemControle.ip);

		AgenteEstrangeiro agenteEstrangeiro = new AgenteEstrangeiro(false);
		agenteEstrangeiro.avisarAgenteHome(mensagemControle);
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

	public void avisarAgenteHome(MensagemControle mensagemControle) {
		try {
			Registry registry = LocateRegistry.getRegistry(coaHome, AgenteHomeConstant.RMI_PORT);
			final AgenteHomeInterface agenteHome = (AgenteHomeInterface) registry.lookup(AgenteHomeConstant.RMI_ID);

			agenteHome.receberAgenteEstrangeiro(mensagemControle);

			System.out.println("Avisar agente Home " + coaHome);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
