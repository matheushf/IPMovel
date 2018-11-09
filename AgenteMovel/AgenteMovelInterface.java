package AgenteMovel;

import java.rmi.Remote;
import java.rmi.RemoteException;

import AgenteHome.*;
import Mensagem.Mensagem;
import AgenteEstrangeiro.*;

public interface AgenteMovelInterface extends Remote {
    public void enviaMensagem(Mensagem mensagem);

    public AgenteHomeInterface conectaHomeAgent(String ip) throws RemoteException;;

    public AgenteEstrangeiroInterface conectaForeignAgent(String ip) throws RemoteException;;
}