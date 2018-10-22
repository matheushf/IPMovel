package NoMovel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interf.Constant;
import interf.HelloInterface;
import server.RMIServer;

public class NoMovel {

	public RMIServer rmiServer = new RMIServer();

	public void main(String[] args) {
		rmiServer.iniciarServer();
	}
}