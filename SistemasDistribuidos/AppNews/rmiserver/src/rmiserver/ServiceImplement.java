package rmiserver;

import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
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

    public ServiceImplement(int maxNews) throws RemoteException {
        this.maxNews = maxNews;
        insertUsers();        
    }

    private void insertUsers(){
        users.add(new User(1, "Gustavo", "gustavo", "gustavo", TypeUser.PUBLISHER));
        users.add(new User(2, "Marcus", "marcus", "marcus", TypeUser.SUBSCRIBER));
        users.add(new User(3, "Willian", "william", "william", TypeUser.PUBLISHER));
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
        return user;
    }

    @Override
    public boolean doConnectionSocket(User user, String ip) throws RemoteException {
        user.setIp(ip);
        Socket socket = null;
        try {
            socket = new Socket(ip, 12345);
        } catch (IOException e) {
            return false;
        }
        user.setSocket(socket);
        return true;
    }

    @Override
    public Topic addTopic(User user, String name) throws RemoteException {
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
        for(Topic t : topics){
            str.add(t.getName());
        }
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
    
    private void shareNewsWithSubscribers(News news, Topic topic){
        topic.getSubscribers().stream().filter((s) -> (s.getSocket() != null)).forEach((s) -> {
            String newsStr = "Tópico: " + topic.getName() + "\n" + news.getContent() + "\n\n";
            byte[] bytes = newsStr.getBytes();
            try {
                s.getSocket().getOutputStream().write(bytes);
                s.getSocket().getOutputStream().flush();
            } catch (IOException ex) {
                s.setSocket(null);
                System.out.println("Usuário desconectado: " + s.getName());                                        
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
