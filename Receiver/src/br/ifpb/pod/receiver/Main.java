package br.ifpb.pod.receiver;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException {

		System.out.println("receiver");		
		Registry registry = LocateRegistry.createRegistry(8081);

		registry.bind("Receiver", new ReceiverImpl());

	}

}
