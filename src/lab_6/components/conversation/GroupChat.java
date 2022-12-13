package lab_6.components.conversation;

import lab_6.components.User;

import java.util.UUID;

public class GroupChat extends Conversation {

    private String tittle;

    public GroupChat() {
        id = UUID.randomUUID().toString();
        if(users.get(2) != null){
            this.tittle = users.get(0).getUsername() + ", " + users.get(1).getUsername() + ", " + users.get(2);
        }
    }

    public GroupChat(String tittle) {
        id = UUID.randomUUID().toString();
        this.tittle = tittle;
    }

    public void removeParticipant(User user) {
        users.remove(user);
    }

    public void addParticipant(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public String getTittle() {
        return tittle;
    }
}
