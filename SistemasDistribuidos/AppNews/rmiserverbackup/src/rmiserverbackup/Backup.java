package rmiserverbackup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import rmicore.domain.Topic;

public class Backup {

    private final String BKP_FOLDER = "bkp";
    private final String BKP_FILE = "bkp.json";
    
    public Backup(){  
        createFolderBkp();
    }
    
    public void doBackupTopics(ArrayList<Topic> topics){
        if(topics == null){
            deleteBkp();
            return;
        }
        String json = new Gson().toJson(topics);
        System.out.println(json);
        try (FileWriter writer = new FileWriter(BKP_FOLDER + File.separator + BKP_FILE)) {
            writer.write(json);
	} catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro no backup dos dados: " + e.getMessage());                
	}	           
    }
    
    public ArrayList<Topic> restoreBackup(){
        ArrayList<Topic> topics = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader((BKP_FOLDER + File.separator + BKP_FILE)));
            topics = new Gson().fromJson(br, new TypeToken<ArrayList<Topic>>(){}.getType());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro no restore dos dados: " + e.getMessage());                
        }
        return topics;
    }
    
    private void createFolderBkp(){
        File folder = new File(BKP_FOLDER);
        if(!folder.exists()){
            folder.mkdir();
        }
    }
    
    private void deleteBkp(){
        File bkp = new File(BKP_FOLDER + File.separator + BKP_FILE);
        if(bkp.exists()){
            bkp.delete();
        }
    }    
    
    
}
