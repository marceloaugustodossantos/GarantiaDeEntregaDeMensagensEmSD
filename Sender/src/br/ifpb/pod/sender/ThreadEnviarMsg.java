package br.ifpb.pod.sender;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.temporal.TemporalField;

import br.ifpb.pod.pingclient.PingClient;
import br.ifpb.pod.receiver.Receiver;

public class ThreadEnviarMsg extends Thread {

	private int id;
	private String msg;

	public ThreadEnviarMsg(int id, String msg) {
		this.id = id;
		this.msg = msg;
	}

	@Override
	public void run() {
		super.run();
		tentarEnvio(msg);
	}
		
	private void tentarEnvio(String msg) {
		//condição para verificar a conexão e a latência
		boolean condition = true;
		while (condition) {
			try {
				Long latencia = verificarLatencia();
				if (latencia != null && latencia > 3000) {
					SenderImpl.responces.put(id, "Conexão lenta!");
				}

				boolean tente = true;
				long tempoTotal = 0;
				long tempoAntes = 0;
				long tempoDepois = 0;
				while (tente) {
					tempoAntes = System.currentTimeMillis();
					if (tempoTotal >= 180000) {
						SenderImpl.responces.put(id, "Falha ao enviar! tentando novamente...");
						tempoAntes = 0;
						tempoDepois = 0;
						tempoTotal = 0;
					}
					try {
						String response = getReceiver().receive(msg);
						SenderImpl.responces.put(id, "Mensagem enviada! \n " + response);
						tente = false;
					} catch (RemoteException | NotBoundException e) {
						e.printStackTrace();
					}
					tempoDepois = System.currentTimeMillis();
					tempoTotal += tempoDepois - tempoAntes;
				}

			} catch (NotBoundException | RemoteException e1) {
				SenderImpl.responces.put(id, "Sem conexão!");				
			}
		}
	}

	private Long verificarLatencia() throws NotBoundException, RemoteException {
		Registry registry = LocateRegistry.getRegistry("localhost", 8084);
		PingClient pingClient = (PingClient) registry.lookup("PingClient");
		return pingClient.ping();
	}

	private Receiver getReceiver() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 8081);
		Receiver receiver = (Receiver) registry.lookup("Receiver");
		return receiver;
	}

}
