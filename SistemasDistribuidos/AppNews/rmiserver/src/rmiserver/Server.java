package rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmicore.Service;

public class Server {
    
    public static void main(String[] args) throws RemoteException {        
        Registry registry = LocateRegistry.createRegistry(9999);
        ServiceImplement srvImp = new ServiceImplement(5);
        Service serv = (Service) UnicastRemoteObject.exportObject(srvImp, 0);
        registry.rebind("127.0.0.1/service", serv);
        System.out.println("Servidor no ar");
    }
}
