package rmiclient.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceClient extends Remote{
    
    /**
     * 
     * @param news notícia
     * @throws RemoteException 
     */
    public void receiveNews(String news) throws RemoteException;
}
