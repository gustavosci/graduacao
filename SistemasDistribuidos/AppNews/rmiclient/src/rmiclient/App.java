package rmiclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiclient.frames.LoginFrame;
import rmicore.Service;

public class App {
 
    private static Service rm;
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
        rm = (Service) registry.lookup("127.0.0.1/service");
        initialFrame();
    }

    private static void initialFrame() throws RemoteException {
        LoginFrame loginFrm = new LoginFrame(rm);
        loginFrm.setVisible(true);
    }
    
    private static void consultNewsByDate() throws RemoteException {
    
    }
     
    private static void consultLastNewsOfTopic() throws RemoteException {
    
    }
    
}
