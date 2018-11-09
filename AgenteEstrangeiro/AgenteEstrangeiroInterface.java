package AgenteEstrangeiro;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Mensagem.Mensagem;

public interface AgenteEstrangeiroInterface extends Remote {

  void reconhecimento(String ip);

  void encaminhaMensagem(Mensagem mensagem);

}