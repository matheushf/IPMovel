package AgenteHome;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AgenteHomeInterface extends Remote {

  Boolean verifica(String ip) throws RemoteException;

  String obtemCoA(String ip) throws RemoteException;

  void encaminhaMensagem(String ip, String mensagem) throws RemoteException;

}