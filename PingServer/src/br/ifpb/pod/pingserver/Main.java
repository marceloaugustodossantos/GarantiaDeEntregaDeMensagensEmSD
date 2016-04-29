package br.ifpb.pod.pingserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		System.out.println("ping server");
		Registry registry = LocateRegistry.createRegistry(8083);

		registry.bind("PingServer", new PingServerImpl());

	}

}
