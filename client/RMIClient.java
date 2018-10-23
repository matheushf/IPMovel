package client;

import interf.Constant;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

  public String RMI_ID = "";
  public int RMI_PORT = 0;

  public RMIClient(String rmi_id, int rmi_port) {
    this.RMI_ID = rmi_id;
    this.RMI_PORT = rmi_port;
  }

  public static void main() {
  }

  public InterfaceClient conectar(String ip, Interface InterfaceClient) {
    try {
      Registry registry = LocateRegistry.getRegistry(ip, RMI_PORT);
      final InterfaceClient client = (InterfaceClient) registry.lookup(RMI_ID);      

      return client;
      
    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString());
      e.printStackTrace();
    }

  }
}
