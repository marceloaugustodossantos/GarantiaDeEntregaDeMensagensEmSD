package br.ifpb.pod.sender;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main {

	public static void main(String[] args)throws RemoteException, AlreadyBoundException  {
		System.out.println("sender");
		Registry registry = LocateRegistry.createRegistry(8082);
		
		registry.bind("Sender", new SenderImpl());
		
	}

}
