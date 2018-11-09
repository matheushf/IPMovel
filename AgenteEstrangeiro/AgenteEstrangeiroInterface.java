package AgenteEstrangeiro;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Mensagem;

public interface AgenteEstrangeiroInterface extends Remote {

  void encaminhaMensagem(Mensagem mensagem);

}