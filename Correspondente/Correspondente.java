package Correspondente;

import AgenteMovel.AgenteMovel;
import client.Mensagem;
import Correspondente.CorrespondenteConstant;

public class Correspondente {

  AgenteMovel agenteMovel = new AgenteMovel();
  public static Mensagem mensagem  = new Mensagem("OI", "172.16.0.90", "172.16.0.89");

  public void main(String args[]) {
      transmitirMensagem(Mensagem mensagem);
  }

  public void transmitirMensagem(Mensagem mensagem) {
    agenteMovel.enviaMensagem(CorrespondenteConstant.coa, CorrespondenteConstant.ipDestinatario, mensagem);
  }
}
