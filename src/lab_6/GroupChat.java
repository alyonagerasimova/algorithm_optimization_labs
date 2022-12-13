package lab_6;


public class GroupChat extends Conversation{

//    private HashSet<Participant> users;
//    private Message[] messages;
//
//    public GroupChat(){}
//
//    public GroupChat(HashSet<Participant> users){
//        this.users = users;
//    }
//
//    public void addUser(Participant user){
//        users.add(user);
//    }

    public void removeParticipant(Participant user) {
        participants.remove(user);
    }

    public void addParticipant(Participant user) {
        participants.add(user);
    }
}
