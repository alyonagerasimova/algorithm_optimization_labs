package lab_6.components.conversation;

import lab_6.components.Message;
import lab_6.components.User;

import java.util.*;

public abstract class Conversation {
    protected ArrayList<User> users = new ArrayList<>();
    protected String id;
    protected ArrayList<Message> messages = new ArrayList<>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void showMessageHistory() {
        for (Message mes : messages) {
            System.out.println("Text: " + "'" + mes.getText() + "'" + ". Date: " + mes.getDate());
        }
    }

    public boolean addMessage(Message message) {
        messages.add(message);
        return true;
    }

    public String getId() {
        return id;
    }
}
