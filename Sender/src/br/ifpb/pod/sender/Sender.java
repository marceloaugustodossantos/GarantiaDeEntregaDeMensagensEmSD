package br.ifpb.pod.sender;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Sender extends Remote{
	
	public void sendMessage(String msg, int id)throws RemoteException;
	
	public Map<Integer, String> verificarResposta() throws RemoteException;

}
