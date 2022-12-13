package lab_6.components.conversation;

import lab_6.components.User;

import java.util.UUID;

public class PrivateChat extends Conversation{

    public PrivateChat(User user1, User user2){
        id = UUID.randomUUID().toString();
        users.add(user1);
        users.add(user2);
    }
}
