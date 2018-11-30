package Roteamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roteamento {

  public static ArrayList<String> coas = new ArrayList<String>();
  public static ArrayList<String> ipsDestino = new ArrayList<String>();

  public static void main() {

    List<String> tempIps = Arrays.asList("");
    ipsDestino.addAll(tempIps);

    List<String> tempCoA = Arrays.asList("172.16.0.82");
    coas.addAll(tempCoA);
  }

  public void mapearNoMovel(String novoCoa, String novoIpDestino) {
    ipsDestino.add(novoIpDestino);
    coas.add(novoCoa);

    System.out.println("Novo ip adicionado: " + novoIpDestino);
    System.out.println("Novo coa adicionado: " + novoCoa);
  }

  // Verificar se o ip enviado existe na mesma posicao que o CoA, para validar se
  // esta na mesma rede
  public Boolean validaIp(String ip, String coaRecebido) {
    int indexIp = Arrays.asList(ipsDestino).indexOf(ip);
    int indexCoA = Arrays.asList(coas).indexOf(coaRecebido);

    System.out.println("validaIp: " + ip + " - " + coaRecebido);

    return indexIp == indexCoA;
  }

  // Enviar o CoA do ip recebido
  public String getCoAIp(String ip) {
    int indexIp = Arrays.asList(ipsDestino).indexOf(ip);
    String novoCoa = coas.get(indexIp);

    System.out.println("getCoAIp: " + ip + " - " + novoCoa);

    return novoCoa;
  }
}
