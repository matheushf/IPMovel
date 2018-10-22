package server;

import interf.Constant;
import interf.HelloInterface;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements HelloInterface {

	/**
	 * Construtor
	 */
	public RMIServer() {
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
	public static void main(String args[]) throws RemoteException {

	}

	public void iniciarServer() {
		try {

			RMIServer rmiServer = new RMIServer();
			HelloInterface helloInterface = (HelloInterface) UnicastRemoteObject.exportObject(rmiServer, 0);

			Registry registry = LocateRegistry.createRegistry(Constant.RMI_PORT);

			registry.bind(Constant.RMI_ID, helloInterface);

			System.out.println("Server ready!");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public void receberMensagem(String mensagem) {
		System.out.println(mensagem);
	}
}