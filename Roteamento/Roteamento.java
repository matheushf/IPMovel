package Roteamento;

import java.util.ArrayList;
import java.util.Arrays;;

public class Roteamento implements HelloInterface {

  public static ArrayList<String> ipsDestino = new ArrayList<String>();
  public static ArrayList<String> coa = new ArrayList<String>();

  public static void main() {

    List<String> tempIps = Arrays.asList("0.0.0.0", "0.0.0.0");
    ipsDestino.addAll(tempIps);

    List<String> tempCoA = Arrays.asList("0.0.0.0", "0.0.0.0");
    coa.addAll(tempCoA);
  }

  // Verificar se o ip enviado existe na mesma posiçaõ que o CoA, para validar se
  // está na mesma rede
  public Boolean validaIp(String ip, String CoA) {
    Int indexIp = Arrays.asList(ipsDestino).indexOf(ip);
    Int indexCoA = Arrays.asList(coa).indexOf(CoA);

    return indexIp == indexCoA;
  }

  // Enviar o CoA do ip recebido
  public String getCoAIp(String ip) {
    Int indexIp = Arrays.asList(ipsDestino).indexOf(ip);

    return coa.get(indexIp);
  }
}
