package AgenteMovel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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

  public void enviaMensagem(String coa, String ip, String mensagem) {
    // AgenteHomeInterface homeAgent = clientHome.conectar(coa);
    AgenteHomeInterface homeAgent = conectaHomeAgent(coa);

    // Verificar se o ip existe no HA
    Boolean existe = homeAgent.verifica(ip, coa);

    if (existe) {
      homeAgent.encaminhaMensagem(ip, mensagem);
    } else {
      // Caso nao exista no HA, obter o CoA do FA e conectar novamente
      String coaFA = homeAgent.obtemCoA(ip);

      // AgenteEstrangeiroInterface foreignAgent = clientEstrangeiro.conectar(coaFA);
      AgenteEstrangeiroInterface foreignAgent = conectaForeignAgent(coa);
      foreignAgent.encaminhaMensagem(ip, mensagem);
    }
  }

  public AgenteHomeInterface conectaHomeAgent(String ip) {
    AgenteHomeInterface homeAgent = null;

    try {
			Registry registry = LocateRegistry.getRegistry(ip, AgenteHomeConstant.RMI_PORT);
			homeAgent = (AgenteHomeInterface) registry.lookup(AgenteHomeConstant.RMI_ID);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
      
		} finally {
      return homeAgent;
    } 
  }

  public AgenteEstrangeiroInterface conectaForeignAgent(String ip) {
    AgenteEstrangeiroInterface foreignAgent = null;

    try {
			Registry registry = LocateRegistry.getRegistry(ip, AgenteEstrangeiroConstant.RMI_PORT);
			foreignAgent = (AgenteEstrangeiroInterface) registry.lookup(AgenteEstrangeiroConstant.RMI_ID);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();

		} finally {
      return foreignAgent;
    }        
  }
}