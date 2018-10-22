package Correspondente;

import interf.Constant;
import interf.HelloInterface;
import AgenteHome.AgenteHome;
import cliente.RMIClient;
import client.RMIClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Correspondente {

  public RMIClient rmiClient = new RMIClient();

  private Correspondente() {
  }

  public void EnviaMensagem(String coa, String ip, String mensagem) {
    homeAgent = rmiClient.conectar(coa);

    Boolean existe = homeAgent.verifica(ip);

    if (existe) {
      homeAgent.encaminhaMensagem(ip, mensagem);
    } else {
      // Caso não exista no HA, obter o ip do FA e conectar novamente
      String coaFA = homeAgent.obtemCoA(ip);

      foreignAgent = rmiClient.conectar(coaFA);
      foreignAgent.encaminhaMensagem(ip, mensagem);
    }
  }

  public static void main(String args[]) {

  }
}