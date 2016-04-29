package br.ifpb.pod.pingserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PingServer extends Remote {
	
	public void ping()throws RemoteException;

}
