package AgenteEstrangeiro;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Mensagem.Mensagem;

public interface AgenteEstrangeiroInterface extends Remote {

  void encaminhaMensagem(Mensagem mensagem);

}