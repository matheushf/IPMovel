package Correspondente;

import AgenteMovel.AgenteMovel;
import Correspondente.CorrespondenteConstant;

public class Correspondente {

  AgenteMovel agenteMovel = new AgenteMovel();

  public void main(String args[]) {
  }

  public void transmitirMensagem(String mensagem) {
    agenteMovel.enviaMensagem(CorrespondenteConstant.coa, CorrespondenteConstant.ipDestinatario, mensagem);
  }
}