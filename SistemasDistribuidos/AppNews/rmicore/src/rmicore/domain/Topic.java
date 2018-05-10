package rmicore.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Topic implements Serializable{
    
    private String name;
    private User publisher;
    private ArrayList<News> news = new ArrayList<>();
    private ArrayList<User> subscribers = new ArrayList<>();
    
    public Topic(String name, User publisher){
        this.name = name;
        this.publisher = publisher;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public ArrayList<News> getNews(){
        return news;
    }

    public void setNews(ArrayList<News> news){
        this.news = news;
    }

    public void addNews(News news){
        this.news.add(news);
    }

    public ArrayList<User> getSubscribers(){
        return subscribers;
    }

    public void setSubscribers(ArrayList<User> subscribers){
        this.subscribers = subscribers;
    }

    public void addSubscriber(User subscriber){
        this.subscribers.add(subscriber);
    }    
}
