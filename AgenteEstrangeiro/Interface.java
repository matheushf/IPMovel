package AgenteEstrangeiro;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceAgenteEstrangeiro extends Remote {

  String obtemCoA() throws RemoteException;

  void encaminhaMensagem() throws RemoteException;

}