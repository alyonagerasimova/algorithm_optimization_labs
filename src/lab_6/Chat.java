package lab_6;

import java.util.Date;

public class Chat {

    private String id;
    private Participant user1;
    private Participant user2;
    private Date dateOfCreation;
    private Message[] messages;
    private Chat instance;

    private Chat(){}

    public Chat get(String userId){
        if(userId != null){
            return instance;
        }
        return null;
    }


    public void displayMessage(){
        for (Message message : messages){
            System.out.println(message.getDescription());
        }
    }

}
