package br.ifpb.pod.pingclient;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main {
	public static void main(String[] args)throws RemoteException, AlreadyBoundException  {
		System.out.println("ping client");
		Registry registry = LocateRegistry.createRegistry(8084);
		
		registry.bind("PingClient", new PingClientImpl());
		
	}
}
