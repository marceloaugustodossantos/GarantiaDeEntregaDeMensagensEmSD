package br.ifpb.pod.clientapp;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

import br.ifpb.pod.sender.Sender;

public class ThreadEviarMensagem extends Thread {

	private String msg;
	private int id;
	private Sender sender;

	public ThreadEviarMensagem(Sender sender, String msg, int id) {
		this.msg = msg;
		this.id = id;
		this.sender = sender;
	}

	@Override
	public void run() {
		super.run();
		enviarMensagem();
	}

	private void enviarMensagem() {
		try {
			sender.sendMessage(msg, id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
