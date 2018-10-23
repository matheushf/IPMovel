package AgenteMovel;

import client.RMIClient;
import AgenteMovel.AgenteMovelConstant;
import AgenteHome.*;
import AgenteEstrangeiro.*;

public class AgenteMovel {

  // public RMIClient rmiClient = new RMIClient(AgenteMovelConstant.RMI_ID,
  // AgenteMovelConstant.RMI_PORT);
  public RMIClient clientHome = new RMIClient(AgenteHomeConstant.RMI_ID, AgenteHomeConstant.RMI_PORT);
  public RMIClient clientEstrangeiro = new RMIClient(AgenteEstrangeiroConstant.RMI_ID,
      AgenteEstrangeiroConstant.RMI_PORT);

  public void main(String args[]) {

  }

  public void enviaMensagem(String coa, String ip, String mensagem) {
    AgenteHomeInterface homeAgent = clientHome.conectar(coa);

    // Verificar se o ip existe no HA
    Boolean existe = homeAgent.verifica(ip);

    if (existe) {
      homeAgent.encaminhaMensagem(ip, mensagem);
    } else {
      // Caso não exista no HA, obter o CoA do FA e conectar novamente
      String coaFA = homeAgent.obtemCoA(ip);

      AgenteEstrangeiroInterface foreignAgent = clientEstrangeiro.conectar(coaFA);
      foreignAgent.encaminhaMensagem(ip, mensagem);
    }
  }

}