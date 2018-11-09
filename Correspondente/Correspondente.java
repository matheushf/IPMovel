package Correspondente;

import AgenteMovel.AgenteMovel;
import client.Mensagem;
import Correspondente.CorrespondenteConstant;

public class Correspondente {

  AgenteMovel agenteMovel = new AgenteMovel();
  public static Mensagem mensagem  = new Mensagem("OI", "172.16.0.90", "172.16.0.92", "0.0.0.0");

  public void main(String args[]) {
    transmitirMensagem(mensagem);
  }

  public void transmitirMensagem(Mensagem mensagem) {
    System.out.println("Correspondente transmitirMensagem");
    agenteMovel.enviaMensagem(mensagem);
  }
}
