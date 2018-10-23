package Roteamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roteamento {

  public static ArrayList<String> coa = new ArrayList<String>();
  public static ArrayList<String> ipsDestino = new ArrayList<String>();

  public static void main() {

    List<String> tempIps = Arrays.asList("0.0.0.0", "0.0.0.0");
    ipsDestino.addAll(tempIps);

    List<String> tempCoA = Arrays.asList("0.0.0.0", "0.0.0.0");
    coa.addAll(tempCoA);
  }

  // Verificar se o ip enviado existe na mesma posicao que o CoA, para validar se
  // esta na mesma rede
  public Boolean validaIp(String ip, String CoA) {
    int indexIp = Arrays.asList(ipsDestino).indexOf(ip);
    int indexCoA = Arrays.asList(coa).indexOf(CoA);

    return indexIp == indexCoA;
  }

  // Enviar o CoA do ip recebido
  public String getCoAIp(String ip) {
    int indexIp = Arrays.asList(ipsDestino).indexOf(ip);

    return coa.get(indexIp);
  }
}
