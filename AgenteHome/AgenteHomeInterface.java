package AgenteHome;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Mensagem;

public interface AgenteHomeInterface extends Remote {

  Boolean verifica(String ip, String coa) throws RemoteException;

  String obtemCoA(String ip) throws RemoteException;

  void encaminhaMensagem(Mensagem mensagem) throws RemoteException;

}