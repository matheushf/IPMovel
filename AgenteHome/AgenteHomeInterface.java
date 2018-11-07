package AgenteHome;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AgenteHomeInterface extends Remote {

  Boolean verifica(String ip, String coa);

  String obtemCoA(String ip);

  void encaminhaMensagem(String ip, String mensagem);

}