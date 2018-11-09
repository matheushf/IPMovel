package Correspondente;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Mensagem;

public interface CorrespondenteInterface extends Remote {

  void transmitirMensagem(Mensagem mensagem);
}