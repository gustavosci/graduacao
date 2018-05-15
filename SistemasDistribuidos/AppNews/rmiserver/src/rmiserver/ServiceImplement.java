package rmiserver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiclient.server.ServiceClient;
import rmicore.Service;
import rmicore.domain.News;
import rmicore.domain.Topic;
import rmicore.domain.User;
import rmicore.enums.TypeUser;

public class ServiceImplement implements Service {
    
    private final ArrayList<User> users = new ArrayList<>();
    private ArrayList<Topic> topics = new ArrayList<>();
    private final int maxNews;
    private final int MAX_LENGTH_NEWS = 180;
    private int sequenciaPortSubscriber = 1000;

    public ServiceImplement(int maxNews) throws RemoteException {
        this.maxNews = maxNews;
        insertUsers();        
    }

    private void insertUsers(){
        users.add(new User(1, "Gustavo", "gustavo", "gustavo", TypeUser.PUBLISHER));
        users.add(new User(2, "Marcus", "marcus", "marcus", TypeUser.SUBSCRIBER));
        users.add(new User(3, "Willian", "william", "william", TypeUser.PUBLISHER));
        users.add(new User(4, "Teste", "teste", "teste", TypeUser.SUBSCRIBER));
    }

    @Override
    public User login(String username, String password) throws RemoteException {
        User user = null;
        for(User u : users){
            if(u.getUsername().equals(username)){
                user = u;
                break;
            }
        }
        if(user == null){
            return null;
        }
        if(!user.getPassword().equals(password)){
            return null;
        }
        user.setIp(null);
        if(user.getType().equals(TypeUser.SUBSCRIBER)){
            sequenciaPortSubscriber += 1;
            user.setPort(sequenciaPortSubscriber);
        }
        return user;
    }

    @Override
    public Topic addTopic(User user, String name) throws RemoteException {
        if(user == null || name == null || name.isEmpty()){
            return null;
        }
        Topic topic = getTopicByName(name);
        if(topic != null){
            return topic;
        }
        topic = new Topic(name, user);
        topics.add(topic);
        return topic;
    }

    @Override
    public ArrayList<String> consultTopicExistings() throws RemoteException {
        ArrayList<String> str = new ArrayList<>();
        topics.forEach((t) -> {
            str.add(t.getName());
        });
        return str;
    }

    @Override
    public News insertNewsOnTopic(User user, String nameTopic, String contentNews) throws RemoteException {
        if(contentNews.length() > MAX_LENGTH_NEWS){
            return null;
        }
        Topic topic = getTopicByName(nameTopic);
        if(topic == null){
            topic = addTopic(user, nameTopic);
        }
        News news = new News(contentNews, user);
        if(topic.getNews().size() == maxNews){
            topic.getNews().remove(0);
        }
        topic.addNews(news);  
        shareNewsWithSubscribers(news, topic);
        return news;                
    }
    
    private void shareNewsWithSubscribers(News news, Topic topic) {        
        String newsStr = "Tópico: " + topic.getName() + "\n" + news.getContent() + "\n\n";
        topic.getSubscribers().stream().filter((s) -> (s.getPort() != 0 && !s.getIp().isEmpty())).forEach((s) -> {
            try {
                Registry registry = LocateRegistry.getRegistry(s.getIp(), s.getPort());
                ServiceClient rmcli = (ServiceClient) registry.lookup(s.getIp() + "/serviceclient");
                rmcli.receiveNews(newsStr);
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(ServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
        });            
    }

    @Override
    public ArrayList<String> consultNewsPublished(User user) throws RemoteException {
        ArrayList<String> newsPub = new ArrayList<>();
        for(int i = 0;i<topics.size();i++){
            for(News n : topics.get(i).getNews()){
                if(Objects.equals(n.getPublisher().getId(), user.getId())){
                    newsPub.add("Tópico: " + topics.get(i).getName() + "\n" + n.getContent() + "\n\n");
                }
            }
        }
        return newsPub;        
    }

    @Override
    public boolean subscribeOnTopic(User user, String nameTopic) throws RemoteException {
        Topic topic = getTopicByName(nameTopic);
        if(topic == null){
            return false;
        }
        if (topic.getSubscribers().stream().anyMatch((s) -> (s.getId() == user.getId()))) {
            return true;
        }
        topic.addSubscriber(user);
        return true;
    }

    @Override
    public ArrayList<String> consultNewsByDate(String nameTopic, LocalDate dateInitial, LocalDate dateEnd) throws RemoteException {
        ArrayList<String> newsPub = new ArrayList<>();
        topics.stream().filter((topic) -> (nameTopic.equals(topic.getName()))).forEach((topic) -> {
            topic.getNews().stream().filter((n) -> 
                    ((n.getDate().isEqual(dateInitial) || n.getDate().isAfter(dateInitial)) &&
                     (n.getDate().isEqual(dateEnd)     || n.getDate().isBefore(dateEnd)))).forEach((n) -> {
                        newsPub.add("Tópico: " + topic.getName() + "\n" + "Notícia:" + n.getContent() + "\n" + "Data: " + n.getDate().toString() + "\n\n");
                    });
        });
        return newsPub;        
    }

    @Override
    public String consultLastNewsOfTopic(String nameTopic) throws RemoteException {
        Topic topic = getTopicByName(nameTopic);
        if(topic == null){
            return null;
        }
        if(topic.getNews().isEmpty()){
            return null;
        }
        return topic.getNews().get(topic.getNews().size() - 1).getContent();
    }

    private Topic getTopicByName(String name){
        for(int i = 0;i<topics.size();i++){
            if(topics.get(i).getName().equals(name)){
                return topics.get(i);
            }
        }
        return null;
    }   

    @Override
    public ArrayList<Topic> getAllTopicsAndNews() throws RemoteException {
        return topics;
    }

    @Override
    public void restoreTopicsAndNews(ArrayList<Topic> topics) throws RemoteException {
        this.topics = topics;
    }
}
