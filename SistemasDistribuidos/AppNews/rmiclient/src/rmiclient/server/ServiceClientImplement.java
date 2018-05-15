package rmiclient.server;

import java.rmi.RemoteException;
import rmiclient.frames.HomeSubscriberFrame;

public class ServiceClientImplement implements ServiceClient {

    private HomeSubscriberFrame homeSubscriberFrm;
    
    public void setHomeSubscriberFrm(HomeSubscriberFrame homeSubscriberFrm){
        this.homeSubscriberFrm = homeSubscriberFrm;
    }            
    
    @Override
    public void receiveNews(String news) throws RemoteException {
        homeSubscriberFrm.appendNewsOnFeed(news);
    }
    
}
