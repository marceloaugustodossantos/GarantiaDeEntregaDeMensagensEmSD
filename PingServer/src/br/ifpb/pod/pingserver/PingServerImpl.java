package br.ifpb.pod.pingserver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class PingServerImpl extends UnicastRemoteObject implements PingServer{

	protected PingServerImpl() throws RemoteException {
		super();
	}

	@Override
	public void ping() throws RemoteException {
		
	}

}
