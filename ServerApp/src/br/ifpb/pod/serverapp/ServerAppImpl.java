package br.ifpb.pod.serverapp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import javax.swing.plaf.SliderUI;

public class ServerAppImpl extends UnicastRemoteObject implements ServerApp {

	protected ServerAppImpl() throws RemoteException {
		super();
	}

	@Override
	public String processMessage(String msg) {
		int tempo = new Random().nextInt(5000);
		if (tempo < 2000) {
			tempo = 2000;
		}
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Hello " + msg;
	}

}
