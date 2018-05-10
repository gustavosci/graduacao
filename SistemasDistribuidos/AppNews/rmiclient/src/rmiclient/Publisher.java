package rmiclient;

import java.rmi.RemoteException;
import java.util.ArrayList;
import rmicore.Service;
import rmicore.domain.User;

public class Publisher {
 
    private static Service rm;
    private static User user;

    
    public Publisher(Service rm, User user){
        this.rm = rm;
        this.user = user;
    }   
    
    public void HomePublisher() throws RemoteException{
        rm.addTopic(user, "Teste");
        rm.addTopic(user, "teste2");
        rm.addTopic(user, "teste3");
        
        ArrayList<String> topicos = rm.consultTopicExistings();
        for(String t : topicos){
            System.out.println(t + "\n");
        }
                
        rm.insertNewsOnTopic(user, "teste2", "NEWSSSSSSSSSSS");
        rm.insertNewsOnTopic(user, "teste3", "NEWSSSSSSSSSSS teste 3 1");
        rm.insertNewsOnTopic(user, "teste3", "NEWSSSSSSSSSSS teste 3 2");
        rm.insertNewsOnTopic(user, "teste3", "NEWSSSSSSSSSSS teste 3 3");
        rm.insertNewsOnTopic(user, "teste3", "NEWSSSSSSSSSSS teste 3 4");
        rm.insertNewsOnTopic(user, "teste3", "NEWSSSSSSSSSSS teste 3 5");
        rm.insertNewsOnTopic(user, "teste3", "NEWSSSSSSSSSSS teste 3 6");
        
        ArrayList<String> news = rm.consultNewsPublished(user);
        for(String n : news){
            System.out.println(n);
        }
        
        
    }
        
}
