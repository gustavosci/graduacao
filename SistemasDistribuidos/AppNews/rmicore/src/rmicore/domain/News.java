package rmicore.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class News implements Serializable{
    
    private String content;
    private LocalDate date;
    private User publisher;

    public News(String content, User publisher) {
        this.content = content;
        this.date = LocalDate.now();
        this.publisher = publisher;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public User getPublisher() {
        return publisher;
    }
    
    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

}
