package Correspondente;

import AgenteMovel.AgenteMovel;
import client.Mensagem;
import Correspondente.CorrespondenteConstant;

public class Correspondente {

<<<<<<< HEAD
  AgenteMovel agenteMovel = new AgenteMovel();
  public static Mensagem mensagem  = new Mensagem("OI", "172.16.0.90", "172.16.0.89");

  public void main(String args[]) {
      transmitirMensagem(Mensagem mensagem);
=======
  AgenteMovel agenteMovel = new AgenteMovel(false);
  public static Mensagem mensagem  = new Mensagem("OI", "172.16.0.90", "172.16.0.92");

  public void main(String args[]) {
    transmitirMensagem(mensagem);
>>>>>>> 456ca3f094e5bce846ca0b39268d63750ce2d6e7
  }

  public void transmitirMensagem(Mensagem mensagem) {
    agenteMovel.enviaMensagem(CorrespondenteConstant.coa, CorrespondenteConstant.ipDestinatario, mensagem);
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> 456ca3f094e5bce846ca0b39268d63750ce2d6e7
