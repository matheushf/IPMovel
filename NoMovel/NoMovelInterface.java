package NoMovel;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NoMovelInterface extends Remote {

  void receberMensagem(String mensagem) throws RemoteException;
}