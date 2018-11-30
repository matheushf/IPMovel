package NoMovel;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Mensagem.Mensagem;
import Mensagem.MensagemControle;

public interface NoMovelInterface extends Remote {

  void avisarNoDisponivel(MensagemControle mensagem) throws RemoteException;
  
  void receberMensagem(Mensagem mensagem) throws RemoteException;
}