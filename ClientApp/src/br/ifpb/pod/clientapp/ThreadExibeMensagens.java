package br.ifpb.pod.clientapp;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.ifpb.pod.sender.Sender;

public class ThreadExibeMensagens extends Thread {

	private Sender sender;
	private int id;
	private String msg;
	
	public ThreadExibeMensagens(Sender sender, int id, String msg) {
		this.sender = sender;
		this.id = id;
		this.msg = msg;
	}

	@Override
	public void run() {
		super.run();
		verivicarMensagens();
	}

	public void verivicarMensagens() {
		boolean condition = true;
		while (condition) {
			try {
				Map<Integer, String> resposta = sender.verificarResposta();
				if (resposta != null && resposta.get(id) != null) {
					System.out.println(resposta.get(id));
					if(resposta.get(id).equals("Mensagem enviada! \n Hello " + msg)) {
						break;
					}
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
