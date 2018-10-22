package Roteamento;

import interf.Constant;
import interf.HelloInterface;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Roteamento implements HelloInterface {

  ArrayList<String> ipsDestino = new ArrayList<String>();
  ArrayList<String> coa = new ArrayList<String>();

  public static void main(String args[]) throws RemoteException {

  }

  public Boolean validaIp(String ip, String CoA) {

  }

  public String getCoAIp(String ip) {
    
  }

}