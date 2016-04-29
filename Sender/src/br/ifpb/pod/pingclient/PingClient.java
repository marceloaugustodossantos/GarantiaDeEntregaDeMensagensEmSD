package br.ifpb.pod.pingclient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PingClient extends Remote {
	
	public Long ping() throws RemoteException;

}
