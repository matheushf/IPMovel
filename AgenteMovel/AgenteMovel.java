package AgenteMovel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import client.Mensagem;
import client.RMIClient;
import AgenteMovel.*;
import AgenteHome.*;
import AgenteEstrangeiro.*;

public class AgenteMovel implements AgenteMovelInterface {

  // public RMIClient rmiClient = new RMIClient(AgenteMovelConstant.RMI_ID,
  // AgenteMovelConstant.RMI_PORT);
  // public RMIClient clientHome = new RMIClient(AgenteHomeConstant.RMI_ID, AgenteHomeConstant.RMI_PORT);
  /* public RMIClient clientEstrangeiro = new RMIClient(AgenteEstrangeiroConstant.RMI_ID,
      AgenteEstrangeiroConstant.RMI_PORT); */

  public void main(String args[]) {

  }

  public void enviaMensagem(Mensagem mensagem) {
    String coa = mensagem.coa;
    String ipDestinatario = mensagem.ipDestinatario;
    AgenteHomeInterface homeAgent = conectaHomeAgent(coa);

    // Verificar se o ip existe no HA
    Boolean existe = homeAgent.verifica(ipDestinatario, coa);

    if (existe) {
      homeAgent.encaminhaMensagem(ipDestinatario, mensagem);
    } else {
      // Caso nao exista no HA, obter o CoA do FA e conectar novamente
      String coaFA = homeAgent.obtemCoA(ipDestinatario);

      // AgenteEstrangeiroInterface foreignAgent = clientEstrangeiro.conectar(coaFA);
      AgenteEstrangeiroInterface foreignAgent = conectaForeignAgent(coa);
      foreignAgent.encaminhaMensagem(mensagem);
    }
  }

  public AgenteHomeInterface conectaHomeAgent(String coa) {
    AgenteHomeInterface homeAgent = null;

    try {
			Registry registry = LocateRegistry.getRegistry(coa, AgenteHomeConstant.RMI_PORT);
			homeAgent = (AgenteHomeInterface) registry.lookup(AgenteHomeConstant.RMI_ID);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
      
		} finally {
      return homeAgent;
    } 
  }

  public AgenteEstrangeiroInterface conectaForeignAgent(String coa) {
    AgenteEstrangeiroInterface foreignAgent = null;

    try {
			Registry registry = LocateRegistry.getRegistry(coa, AgenteEstrangeiroConstant.RMI_PORT);
			foreignAgent = (AgenteEstrangeiroInterface) registry.lookup(AgenteEstrangeiroConstant.RMI_ID);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();

		} finally {
      return foreignAgent;
    }        
  }
}
