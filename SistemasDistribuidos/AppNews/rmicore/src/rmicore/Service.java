package rmicore;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import rmicore.domain.News;
import rmicore.domain.Topic;
import rmicore.domain.User;

public interface Service extends Remote{
    
    // METÓDOS GERAIS
    /**
     * 
     * @param username username
     * @param password senha
     * @return User usuário logado
     * @throws RemoteException 
     */

    public User login(String username, String password) throws RemoteException;
    
    // MÉTODOS PARA ESCRITORES
    /**
     * 
     * @param user usuário
     * @param name nome do tópico
     * @return Topic Tópico inserido
     * @throws RemoteException 
     */
    public Topic addTopic(User user, String name) throws RemoteException;

    /**
     * 
     * @return Array com nome dos tópicos existentes
     * @throws RemoteException 
     */
    public ArrayList<String> consultTopicExistings() throws RemoteException;

    /**
     * 
     * @param user publisher
     * @param topic Nome do tópico
     * @param news Texto da notícia
     * @return News Notícia
     * @throws RemoteException 
     */
    public News insertNewsOnTopic(User user, String topic, String news) throws RemoteException;

    /**
     * 
     * @param user publisher ou null se quiser todas as notícias existentes
     * @return Array das notícias e seu respectivo tópico
     * @throws RemoteException 
     */
    public ArrayList<String> consultNewsPublished(User user) throws RemoteException;
    
    // MÉTODOS PARA LEITORES
    /**
     * 
     * @param user leitor
     * @param topic nome do tópico
     * @return boolean indica se a inscrição foi feita com sucesso
     * @throws RemoteException 
     */
    public boolean subscribeOnTopic(User user, String topic) throws RemoteException;
    
    /**
     * 
     * @param topic nome do tópico
     * @param dateInitial data inicial
     * @param dateEnd data final
     * @return Array das notícias e seu respectivo tópico
     * @throws RemoteException 
     */
    public ArrayList<String> consultNewsByDate(String topic, LocalDate dateInitial, LocalDate dateEnd) throws RemoteException;

    /**
     * 
     * @param topic nome do tópico
     * @return última notícia do tópico
     * @throws RemoteException 
     */
    public String consultLastNewsOfTopic(String topic) throws RemoteException;
    
    /**
     * 
     * @param user leitor
     * @param ip ip da máquina local do leitor
     * @return boolean indica se criou a conexão socket com sucesso
     * @throws RemoteException 
     */
    public boolean doConnectionSocket(User user, String ip) throws RemoteException;
    
    // MÉTODOS PARA BACKUP
    /**
     * 
     * @return tópicos existentes com suas respectivas notícias
     * @throws RemoteException 
     */
    public ArrayList<Topic> getAllTopicsAndNews() throws RemoteException;
    
    /**
     * 
     * @param topics tópicos e notícias
     * @throws RemoteException 
     */
    public void restoreTopicsAndNews(ArrayList<Topic> topics) throws RemoteException;
}
