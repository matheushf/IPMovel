package NoMovel;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Mensagem.Mensagem;

public interface NoMovelInterface extends Remote {

  void avisarNoDisponivel(String coa);
  
  void receberMensagem(Mensagem mensagem) throws RemoteException;
}