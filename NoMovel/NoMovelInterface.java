package NoMovel;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Mensagem;

public interface NoMovelInterface extends Remote {

  void receberMensagem(Mensagem mensagem) throws RemoteException;
}