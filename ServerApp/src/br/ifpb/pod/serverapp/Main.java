package br.ifpb.pod.serverapp;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args)throws RemoteException, AlreadyBoundException  {
		System.out.println("server app");
		Registry registry = LocateRegistry.createRegistry(8080);		
		registry.bind("ServerApp", new ServerAppImpl());		
	}

}
