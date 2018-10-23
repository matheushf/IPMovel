package client;

import interf.Constant;
// import interf.HelloInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

  public static String RMI_ID = "";
  public static int RMI_PORT = 0;

  public static void main(String rmi_id, int rmi_port) {
    RMI_ID = rmi_id;
    RMI_PORT = rmi_port;
  }

  public conectar(String ip, Interface InterfaceClient) {
    try {
      Registry registry = LocateRegistry.getRegistry(ip, RMI_PORT);
      // final HelloInterface homeAgent = (HelloInterface) registry.lookup(RMI_ID);      
      final InterfaceClient client = (InterfaceClient) registry.lookup(RMI_ID);      

      return client;
      
    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString());
      e.printStackTrace();
    }

  }
}
