package br.ifpb.pod.clientapp;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Scanner;

import br.ifpb.pod.sender.Sender;


public class Main {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException {
		System.out.println("client app");
		//
		Registry registry = LocateRegistry.getRegistry("localhost", 8082);
		Sender sender = (Sender) registry.lookup("Sender");
		//
		Scanner in = new Scanner(System.in);
		int id = 0;
		while(true){
			System.out.println("Digite uma mensagem:");
			String msg = in.nextLine();
			ThreadEviarMensagem thread = new ThreadEviarMensagem(sender, msg.trim(), id);
			thread.start();
			ThreadExibeMensagens t = new ThreadExibeMensagens(sender, id++, msg.trim());
			t.start();
		}		
	}

}
