package AgenteHome;

import Roteamento.Roteamento;

public class AgenteHome {

	Roteamento roteamento = new Roteamento();

	public static void main(String args[]) {

	}

	// Verifica se o ip existe no CoA enviado
	public Boolean verifica(String ip, String CoA) {
		return roteamento.validaIp(ip, CoA);
	}

	// Obter CoA a partir do IP enviado
	public String obtemCoA(String ip) {
		return roteamento.getCoAIp(ip);
	}
	
	// Encaminhar mensagem para o ForeignAgent
	public void encaminhaMensagem(String ip, String mensagem) {
		mobileNode = rmiClient.conectar(ip);
		mobileNode.receberMensagem(mensagem);
	}
}