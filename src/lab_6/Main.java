package lab_6;

import java.util.ArrayList;

public class Main {

//    6. Как бы вы подошли к проектированию чат-сервера? Предоставьте информацию о компонентах внутренней подсистемы (backend),
//    классах и методах. Перечислите самые трудные задачи, которые необходимо решить.

    //Беседа групповая
    //Беседа между двумя участниками
    //Участник беседы
    //Сообщение


    public static void main(String[] args) {

        Participant user1 = new Participant("aaa");
        Participant user2 = new Participant("bbb");
        PrivateChat pChat = new PrivateChat(user1, user2);
        System.out.println(pChat.getId());
        pChat.addMessage(new Message("Hi"));
        pChat.addMessage(new Message("Hello"));
        ArrayList<Message> messages = pChat.getMessages();
    }
}
