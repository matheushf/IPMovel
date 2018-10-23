package client;

import interf.Constant;
import interf.HelloInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

  public static void main(String[] args) {

  }

  public conectar(String ip) {
    try {
      Registry registry = LocateRegistry.getRegistry(ip, Constant.RMI_PORT);
      final HelloInterface homeAgent = (HelloInterface) registry.lookup(Constant.RMI_ID);      

      return homeAgent;
      
    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString());
      e.printStackTrace();
    }

  }
}
