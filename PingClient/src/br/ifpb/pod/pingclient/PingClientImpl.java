package br.ifpb.pod.pingclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.ifpb.pod.pingserver.PingServer;


public class PingClientImpl extends UnicastRemoteObject implements PingClient {

	protected PingClientImpl() throws RemoteException {
		super();
	}

	@Override
	public Long ping() throws RemoteException {
		
		try {
			PingServer pingServer = getPingServer();
			long tempoAntes = System.currentTimeMillis();
			pingServer.ping();
			long tempoDepois = System.currentTimeMillis();
			return tempoDepois - tempoAntes;
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private PingServer getPingServer() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 8083);
		PingServer pingServer = (PingServer) registry.lookup("PingServer");
		return pingServer;
	}

}
