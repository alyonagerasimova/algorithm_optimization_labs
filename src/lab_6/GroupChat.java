package lab_6;

import java.util.HashSet;

public class GroupChat {

    private HashSet<Participant> users;
    private Message[] messages;

    public GroupChat(){}

    public GroupChat(HashSet<Participant> users){
        this.users = users;
    }

    public void addUser(Participant user){
        users.add(user);
    }


}
