package rmiclient;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import rmicore.Service;
import rmicore.domain.User;

public class Subscriber {
 
    private static Service rm;
    private static User user;
    
    public Subscriber(Service rm, User user){
        this.rm = rm;
        this.user = user;
    }   

    public void HomeSubscriber() throws RemoteException{
        if(!rm.subscribeOnTopic(user, "teste2")){
            System.out.println("Falou inscrição topico teste2");
        }
        if(!rm.subscribeOnTopic(user, "teste4")){
            System.out.println("Falou inscrição topico teste4");
        }
        
        System.out.println("01/01/2018 a 10/10/2018");        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateIni = LocalDate.parse("01/01/2018",fmt);
        LocalDate dateFin = LocalDate.parse("01/10/2018",fmt);        
        ArrayList<String> news = rm.consultNewsByDate("teste2", dateIni, dateFin);
        for(String n : news){
            System.out.println(n);
        }
        System.out.println("30/05/2018 a 10/10/2018");        
        dateIni = LocalDate.parse("30/05/2018",fmt);
        dateFin = LocalDate.parse("01/10/2018",fmt);        
        news = rm.consultNewsByDate("teste2", dateIni, dateFin);
        for(String n : news){
            System.out.println(n);
        }
        System.out.println("01/05/2018 a 10/05/2018");        
        dateIni = LocalDate.parse("01/05/2018",fmt);
        dateFin = LocalDate.parse("10/05/2018",fmt);        
        news = rm.consultNewsByDate("teste2", dateIni, dateFin);
        for(String n : news){
            System.out.println(n);
        }
        System.out.println("10/05/2018 a 10/05/2018 teste 3");        
        dateIni = LocalDate.parse("10/05/2018",fmt);
        dateFin = LocalDate.parse("10/05/2018",fmt);        
        news = rm.consultNewsByDate("teste3", dateIni, dateFin);
        for(String n : news){
            System.out.println(n);
        }
        
        
        System.out.println("LAST Teste");        
        System.out.println(rm.consultLastNewsOfTopic("Teste"));
        System.out.println("LAST teste1");        
        System.out.println(rm.consultLastNewsOfTopic("teste1"));
        System.out.println("LAST teste2");        
        System.out.println(rm.consultLastNewsOfTopic("teste2"));
        System.out.println("LAST teste3");        
        System.out.println(rm.consultLastNewsOfTopic("teste3"));
        
        
    }

}
