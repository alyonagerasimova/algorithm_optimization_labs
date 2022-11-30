package lab_6;

import java.util.*;

public class Participant {

    private String id;
    private String username;
    private String accountName;
    private HashMap<String, Chat> chats = new HashMap<>();
    private HashMap<String, GroupChat> groupChats = new HashMap<>();
    private String status = null;


    public Participant(String username, String accountName){
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.accountName = accountName;
    }

    public void addUserToChat(){

    }

    public void sendMessageToUser(Participant toUser, String description){
        Chat chat = chats.get(toUser.getId());
        Message message = new Message();


        chat.displayMessage();
    }

    private String getId() {
        return null;
    }

    public void sendMessageToChat(){

    }

}
