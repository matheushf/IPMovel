package AgenteHome;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote {

  Boolean verifica() throws RemoteException;

  String obtemCoA() throws RemoteException;

  void encaminhaMensagem() throws RemoteException;

}