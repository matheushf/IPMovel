package server;

import interf.Constant;
import interf.HelloInterface;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements HelloInterface {

	public String RMI_ID = "";
	public int RMI_PORT = 0;

	/**
	 * Construtor
	 */
	public RMIServer(String rmi_id, int rmi_port) {
		this.RMI_ID = rmi_id;
		this.RMI_PORT = rmi_port;
	}

	/**
	 * Metodo sayHello
	 */
	public String sayHello() {
		return "Hello, world!";
	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 * @throws RemoteException
	 */
	public static void main() {

	}

	/* public void iniciarServer() {
		try {

			RMIServer rmiServer = new RMIServer();
			InterfaceServer server = (InterfaceServer) UnicastRemoteObject.exportObject(rmiServer, 0);

			Registry registry = LocateRegistry.createRegistry(RMI_PORT);

			registry.bind(RMI_ID, server);

			System.out.println("Server ready!");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	} */

}