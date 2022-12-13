package lab_6;

import java.util.Date;

public class PrivateChat extends Conversation{

    private String id;
    private Participant user1;
    private Participant user2;

    public  PrivateChat(Participant user1, Participant user2){
        this.user1 = user1;
        this.user2 = user2;
    }

//    public PrivateChat get(String userId){
//        if(userId != null){
//            return instance;
//        }
//        return null;
//    }
//
//
//    public void displayMessage(){
//        for (Message message : messages){
//            System.out.println(message.getContent());
//        }
//    }
//
//    public void addMessage(Message message) {
//
//    }
}
