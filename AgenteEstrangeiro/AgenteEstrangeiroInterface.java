package AgenteEstrangeiro;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Mensagem.Mensagem;
import Mensagem.MensagemControle;

public interface AgenteEstrangeiroInterface extends Remote {

  void reconhecimento(MensagemControle mensagemControle) throws RemoteException;

  void encaminhaMensagem(Mensagem mensagem) throws RemoteException;

}