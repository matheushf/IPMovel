package Correspondente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CorrespondenteInterface extends Remote {

  void transmitirMensagem(String mensagem);
}