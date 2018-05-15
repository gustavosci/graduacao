package rmiclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import rmiclient.frames.LoginFrame;
import rmicore.Service;

public class App {
 
    private static Service rm;
    
    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src/rmiclient/resources/rmserver.properties");
        props.load(file);
        return props;
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException, IOException {
        Properties prop = getProp();
        String hostServer = prop.getProperty("prop.server.host");
        String portServer = prop.getProperty("prop.server.port");
        
        Registry registry = LocateRegistry.getRegistry(hostServer, Integer.parseInt(portServer));
        rm = (Service) registry.lookup(hostServer + "/service");
        LoginFrame loginFrm = new LoginFrame(rm);
        loginFrm.setVisible(true);
    }
}
