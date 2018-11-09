package AgenteMovel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import client.Mensagem;
import client.RMIClient;
import AgenteMovel.*;
import AgenteHome.*;
import AgenteEstrangeiro.*;

public class AgenteMovel implements AgenteMovelInterface {

  public void main(String args[]) {

  }

  public void enviaMensagem(Mensagem mensagem) {
    String coa = mensagem.coa;
    String ipDestinatario = mensagem.ipDestinatario;

    AgenteHomeInterface homeAgent = conectaHomeAgent(coa);

    // Verificar se o ip existe no HA
    Boolean existe = homeAgent.verifica(ipDestinatario, coa);    

    if (existe) {
      System.out.println("AgenteMovel, nó existe no HA, encaminhando mensagem ");
      homeAgent.encaminhaMensagem(mensagem);
    } else {
      // Caso nao exista no HA, obter o CoA do FA e conectar novamente
      String coaFA = homeAgent.obtemCoA(ipDestinatario);

      System.out.println("AgenteMovel, nó não existe no HA, ip do FA: " + coaFA);

      // AgenteEstrangeiroInterface foreignAgent = clientEstrangeiro.conectar(coaFA);
      AgenteEstrangeiroInterface foreignAgent = conectaForeignAgent(coaFA);
      foreignAgent.encaminhaMensagem(mensagem);
    }
  }

  public AgenteHomeInterface conectaHomeAgent(String coa) {
    AgenteHomeInterface homeAgent = null;

    try {
			Registry registry = LocateRegistry.getRegistry(coa, AgenteHomeConstant.RMI_PORT);
			homeAgent = (AgenteHomeInterface) registry.lookup(AgenteHomeConstant.RMI_ID);

      System.out.println("AgenteHome conectado ");

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

      System.out.println("AgenteEstrangeiro conectado ");

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();

		} finally {
      return foreignAgent;
    }        
  }
}
