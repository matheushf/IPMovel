package Correspondente;

import AgenteMovel.AgenteMovel;

public class Correspondente {

  AgenteMovel agenteMovel = new AgenteMovel();

  public void main(String args[]) {
  }

  public void transmitirMensagem(String coa, String ip, String mensagem) {
    agenteMovel.enviaMensagem(coa, ip, mensagem);
  }
}