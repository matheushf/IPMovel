package Correspondente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import AgenteHome.AgenteHomeConstant;
import AgenteHome.AgenteHomeInterface;
import AgenteMovel.AgenteMovel;
import Mensagem.Mensagem;
import Correspondente.CorrespondenteConstant;

public class Correspondente {

  public static AgenteMovel agenteMovel = new AgenteMovel();
  public static Mensagem mensagem = new Mensagem("OI", "172.16.0.83", "172.16.0.81", "172.16.0.82");

  public static void main(String args[]) {
    transmitirMensagem(mensagem);
  }

  public static void transmitirMensagem(Mensagem mensagem) {
    System.out.println("Correspondente transmitirMensagem para HA: " + mensagem.coa + " NoMovel: " + mensagem.ipDestinatario);
    // agenteMovel.enviaMensagem(mensagem);

    Correspondente correspondente = new Correspondente();
    AgenteHomeInterface homeAgent = correspondente.conectaHomeAgent(mensagem.coa);

    try {
      homeAgent.encaminhaMensagem(mensagem);
    } catch (Exception e) {
      System.err.println("Server exception: " + e.toString());
      e.printStackTrace();
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
}
