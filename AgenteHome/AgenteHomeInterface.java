package AgenteHome;

import java.rmi.Remote;
import java.rmi.RemoteException;

import AgenteEstrangeiro.AgenteEstrangeiroInterface;
import Mensagem.Mensagem;
import Mensagem.MensagemControle;

public interface AgenteHomeInterface extends Remote {

  Boolean verifica(String ip, String coa) throws RemoteException;

  String obtemCoA(String ip) throws RemoteException;
  
  void receberAgenteEstrangeiro(MensagemControle mensagem) throws RemoteException;

  void encaminhaMensagem(Mensagem mensagem) throws RemoteException;

  AgenteEstrangeiroInterface conectaForeignAgent(String coa)  throws RemoteException;

}