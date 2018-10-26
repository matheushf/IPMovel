package AgenteMovel;

import java.rmi.Remote;
import java.rmi.RemoteException;

import AgenteHome.*;
import AgenteEstrangeiro.*;

public interface AgenteMovelInterface extends Remote {
    public void enviaMensagem(String coa, String ip, String mensagem);

    public AgenteHomeInterface conectaHomeAgent(String ip) throws RemoteException;;

    public AgenteEstrangeiroInterface conectaForeignAgent(String ip) throws RemoteException;;
}