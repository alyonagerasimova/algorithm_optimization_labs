package lab_6;

import java.util.*;

public abstract class Conversation {
    protected ArrayList<Participant> participants = new ArrayList<>();
    protected String id;
    protected ArrayList<Message> messages = new ArrayList<>();

    public ArrayList<Message> getMessages() {
        for(Message mes : messages){
            System.out.println("Content: " + "'" + mes.getContent() + "'" + ". Date: " + mes.getDate());
        }
        return messages;
    }

    public boolean addMessage(Message message) {
        messages.add(message);
        return true;
    }

    public String getId() {
        return id;
    }
}
