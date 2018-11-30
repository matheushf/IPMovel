package AgenteMovel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Mensagem.Mensagem;
import client.RMIClient;
import AgenteMovel.*;
import AgenteHome.*;
import AgenteEstrangeiro.*;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteMovel implements AgenteMovelInterface {

  public void main(String args[]) {

  }

  public void enviaMensagem(Mensagem mensagem) {
    String coa = mensagem.coa;
    String ipDestinatario = mensagem.ipDestinatario;

    AgenteHomeInterface homeAgent = conectaHomeAgent(coa);

    // Verificar se o ip existe no HA
    Boolean existe = null;
    try {
      existe = homeAgent.verifica(ipDestinatario, coa);
    } catch (RemoteException ex) {
      Logger.getLogger(AgenteMovel.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (existe) {
      System.out.println("AgenteMovel, no existe no HA, encaminhando mensagem ");
      try {
        homeAgent.encaminhaMensagem(mensagem);
      } catch (RemoteException ex) {
        Logger.getLogger(AgenteMovel.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else {
      // Caso nao exista no HA, obter o CoA do FA e conectar novamente
      String coaFA = null;
      try {
        coaFA = homeAgent.obtemCoA(ipDestinatario);
      } catch (RemoteException ex) {
        Logger.getLogger(AgenteMovel.class.getName()).log(Level.SEVERE, null, ex);
      }

      System.out.println("AgenteMovel, no nao existe no HA, ip do FA: " + coaFA);

      // AgenteEstrangeiroInterface foreignAgent = clientEstrangeiro.conectar(coaFA);
      AgenteEstrangeiroInterface foreignAgent = conectaForeignAgent(coaFA);

      try {
        foreignAgent.encaminhaMensagem(mensagem);
      } catch (RemoteException ex) {
        Logger.getLogger(AgenteMovel.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
  }

  public AgenteHomeInterface conectaHomeAgent(String coa) {
    AgenteHomeInterface homeAgent = null;

    try {
      Registry registry = LocateRegistry.getRegistry(coa, AgenteHomeConstant.RMI_PORT);
      homeAgent = (AgenteHomeInterface) registry.lookup(AgenteHomeConstant.RMI_ID);

      System.out.println("AgenteHome conectado ");

    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString());
      e.printStackTrace();

    } finally {
      return homeAgent;
    }
  }

  public AgenteEstrangeiroInterface conectaForeignAgent(String coa) {
    AgenteEstrangeiroInterface foreignAgent = null;

    try {
      Registry registry = LocateRegistry.getRegistry(coa, AgenteEstrangeiroConstant.RMI_PORT);
      foreignAgent = (AgenteEstrangeiroInterface) registry.lookup(AgenteEstrangeiroConstant.RMI_ID);

      System.out.println("AgenteEstrangeiro conectado ");

    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString());
      e.printStackTrace();

    } finally {
      return foreignAgent;
    }
  }
}
