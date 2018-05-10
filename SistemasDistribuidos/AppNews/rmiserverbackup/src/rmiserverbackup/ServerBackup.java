package rmiserverbackup;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmicore.Service;
import rmiserverbackup.frames.BackupFrame;

public class ServerBackup {

    private static Service rm;
    
    public static void main(String[] args) throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
        rm = (Service) registry.lookup("127.0.0.1/service");
        BackupFrame backupFrm = new BackupFrame(rm);
        backupFrm.setVisible(true);
    }
    
}
