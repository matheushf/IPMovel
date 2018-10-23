package AgenteMovel;

import client.RMIClient;

public class AgenteMovel {

  public RMIClient rmiClient = new RMIClient();

  public void main(String args[]) {

  }

  public void enviaMensagem(String coa, String ip, String mensagem) {
    homeAgent = rmiClient.conectar(coa);

    // Verificar se o ip existe no HA
    Boolean existe = homeAgent.verifica(ip);

    if (existe) {
      homeAgent.encaminhaMensagem(ip, mensagem);
    } else {
      // Caso não exista no HA, obter o CoA do FA e conectar novamente
      String coaFA = homeAgent.obtemCoA(ip);

      foreignAgent = rmiClient.conectar(coaFA);
      foreignAgent.encaminhaMensagem(ip, mensagem);
    }
  }

}