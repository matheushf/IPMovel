package Correspondente;

import AgenteMovel.AgenteMovel;
import Correspondente.Constant;

public class Correspondente {

  AgenteMovel agenteMovel = new AgenteMovel();

  public void main(String args[]) {
  }

  public void transmitirMensagem(String mensagem) {
    agenteMovel.enviaMensagem(Constant.coa, Constant.ipDestinatario, mensagem);
  }
}