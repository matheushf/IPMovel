package AgenteEstrangeiro;

import java.rmi.Remote;
import java.rmi.RemoteException;

<<<<<<< HEAD
=======
import client.Mensagem;

>>>>>>> 456ca3f094e5bce846ca0b39268d63750ce2d6e7
public interface AgenteEstrangeiroInterface extends Remote {

  String obtemCoA(String ip);

<<<<<<< HEAD
  void encaminhaMensagem(String ip, String mensagem);
=======
  void encaminhaMensagem(String ip, Mensagem mensagem);
>>>>>>> 456ca3f094e5bce846ca0b39268d63750ce2d6e7

}