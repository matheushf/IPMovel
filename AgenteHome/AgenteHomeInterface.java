package AgenteHome;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Mensagem;

public interface AgenteHomeInterface extends Remote {

  Boolean verifica(String ip, String coa);

  String obtemCoA(String ip);

  void encaminhaMensagem(Mensagem mensagem);

}