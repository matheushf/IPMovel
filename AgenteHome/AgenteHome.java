package AgenteHome;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import AgenteEstrangeiro.AgenteEstrangeiroConstant;
import AgenteEstrangeiro.AgenteEstrangeiroInterface;
import Roteamento.Roteamento;
import Mensagem.Mensagem;
import Mensagem.MensagemControle;
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
		this.server = server;
	}

	public static void main(String args[]) {
		if (server == true) {
			AgenteHome agenteHome = new AgenteHome(false);
			agenteHome.iniciaServer(agenteHome);
		}
	}

	public void iniciaServer(AgenteHome agenteHome) {
		try {
			AgenteHomeInterface server = (AgenteHomeInterface) UnicastRemoteObject.exportObject(agenteHome, 0);

			Registry registry = LocateRegistry.createRegistry(AgenteHomeConstant.RMI_PORT);

			registry.bind(AgenteHomeConstant.RMI_ID, server);

			System.out.println("AgenteHome ready!");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
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

	public AgenteEstrangeiroInterface conectaForeignAgent(String coa) {
		AgenteEstrangeiroInterface foreignAgent = null;

		try {
			Registry registry = LocateRegistry.getRegistry(coa, AgenteEstrangeiroConstant.RMI_PORT);
			foreignAgent = (AgenteEstrangeiroInterface) registry.lookup(AgenteEstrangeiroConstant.RMI_ID);

			System.out.println("AgenteEstrangeiro conectado ");

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();

		} finally {
			return foreignAgent;
		}
	}

	// Encaminhar mensagem para o ForeignAgent
	public void encaminhaMensagem(Mensagem mensagem) {
		AgenteHome agenteHome = new AgenteHome(false);

		// Obter qual agente estrangeiro o no esta
		String coaFA = this.obtemCoA(mensagem.ipDestinatario);

		System.out.println("AgenteHome recebe mensagem, encaminhar para " + coaFA + " NoMovel: " + mensagem.ipDestinatario);

		AgenteEstrangeiroInterface foreignAgent = agenteHome.conectaForeignAgent(coaFA);
		try {
			foreignAgent.encaminhaMensagem(mensagem);
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public void receberAgenteEstrangeiro(MensagemControle mensagemControle) {
		System.out.println("AgenteHome recebe noMovel: " + mensagemControle.ip + " e ForeignAgent: " + mensagemControle.coa);
		roteamento.mapearNoMovel(mensagemControle.coa, mensagemControle.ip);
	}

	/*
	 * try { Registry registry = LocateRegistry.getRegistry(ipDestinatario,
	 * NoMovelConstant.RMI_PORT); final NoMovelInterface noMovel =
	 * (NoMovelInterface) registry.lookup(NoMovelConstant.RMI_ID);
	 * 
	 * System.out.println("NoMovel conectado no HA ");
	 * 
	 * noMovel.receberMensagem(mensagem);
	 * 
	 * } catch (Exception e) { System.err.println("Client exception: " +
	 * e.toString()); e.printStackTrace(); }
	 */
}