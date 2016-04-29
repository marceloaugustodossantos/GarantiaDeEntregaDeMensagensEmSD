package br.ifpb.pod.serverapp;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerApp extends Remote{
	
	public String processMessage(String msg)throws RemoteException;

}
