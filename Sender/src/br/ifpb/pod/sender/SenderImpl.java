package br.ifpb.pod.sender;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;


public class SenderImpl extends UnicastRemoteObject implements Sender {

	protected SenderImpl() throws RemoteException {
		super();
	}

	static Map<Integer, String> responces = new HashMap<>();
	
	@Override
	public void sendMessage(String msg, int id) throws RemoteException {
		ThreadEnviarMsg thread = new ThreadEnviarMsg(id, msg);
		thread.run();
	}

	@Override
	public Map<Integer, String> verificarResposta() throws RemoteException {
		return responces;
	}	

}
