package Correspondente;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Mensagem.Mensagem;

public interface CorrespondenteInterface extends Remote {

  void transmitirMensagem(Mensagem mensagem);
}