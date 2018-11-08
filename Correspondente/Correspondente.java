package Correspondente;

import AgenteMovel.AgenteMovel;
import client.Mensagem;
import Correspondente.CorrespondenteConstant;

public class Correspondente {

  AgenteMovel agenteMovel = new AgenteMovel(false);
  public static Mensagem mensagem  = new Mensagem("OI", "172.16.0.90", "172.16.0.92");

  public void main(String args[]) {
    transmitirMensagem(mensagem);
  }

  public void transmitirMensagem(Mensagem mensagem) {
    agenteMovel.enviaMensagem(mensagem);
  }
}
