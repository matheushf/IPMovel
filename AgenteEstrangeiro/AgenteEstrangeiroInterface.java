package AgenteEstrangeiro;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AgenteEstrangeiroInterface extends Remote {

  String obtemCoA(String ip) throws RemoteException;

  void encaminhaMensagem(String ip, String mensagem) throws RemoteException;

}