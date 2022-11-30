package lab_6;

import java.time.LocalDateTime;
import java.util.Date;

public class Message {

    private String description;
    private Participant user;
    private LocalDateTime date;
    private String status = null;
    private boolean isSend = false;

    public Message(String description, Participant user){
        this.description = description;
        this.user = user;
    }

    public Message(){}

    public void sendMessage(){

        date = LocalDateTime.now();
//        chat.displayMessage();
        isSend = true;
    }

    public String getDescription(){
        return description;
    }

    public Participant getUser(){
        return user;
    }

    public void readMessage(){
        status = "Read";
    }

    public void displayTimeToSend(){
        System.out.println(date);
    }
}
