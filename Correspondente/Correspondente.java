package Correspondente;

import AgenteMovel.AgenteMovel;
import Mensagem.Mensagem;
import Correspondente.CorrespondenteConstant;

public class Correspondente {

  public static AgenteMovel agenteMovel = new AgenteMovel();
  public static Mensagem mensagem  = new Mensagem("OI", "172.16.0.83", "172.16.0.81", "172.16.0.82");

  public static void main(String args[]) {
    transmitirMensagem(mensagem);
  }

  public static void transmitirMensagem(Mensagem mensagem) {
    System.out.println("Correspondente transmitirMensagem");
    agenteMovel.enviaMensagem(mensagem);
  }
}
