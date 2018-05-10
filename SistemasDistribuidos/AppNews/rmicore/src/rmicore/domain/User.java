package rmicore.domain;

import java.io.Serializable;
import java.net.Socket;
import rmicore.enums.TypeUser;

public class User implements Serializable{
    
    private Integer id;
    private String name;
    private String username;
    private String password;
    private TypeUser type;
    private String ip;
    private Socket socket;

    public User(Integer id, String name, String username, String password, TypeUser type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(TypeUser type) {
        this.type = type;
    }
        
    public Integer getId(){
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public TypeUser getType() {
        return type;
    }

    public String getIp() {
        return ip;
    }

    public Socket getSocket() {
        return socket;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
