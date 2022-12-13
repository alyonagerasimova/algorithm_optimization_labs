package lab_6;

import lab_6.components.Message;
import lab_6.components.User;
import lab_6.components.conversation.GroupChat;
import lab_6.components.conversation.PrivateChat;

public class Main {

//    6. Как бы вы подошли к проектированию чат-сервера? Предоставьте информацию о компонентах внутренней подсистемы (backend),
//    классах и методах. Перечислите самые трудные задачи, которые необходимо решить.

    public static void main(String[] args) {

        User user1 = new User("aaa");
        User user2 = new User("bbb");
        user1.addContact(user2);
        GroupChat groupChat = new GroupChat("GroupChat 1");
        user1.addConversation(groupChat);
        user2.approveRequest(user1);

        System.out.println(user2.getStatus().statusUser);
        User user3 = new User("ccc");
        groupChat.addParticipant(user3);
        groupChat.addParticipant(user2);
        user2.sendMessageToGroupChat(groupChat, "AAA");
        user1.showGroupChats();
        groupChat.showMessageHistory();

        PrivateChat pChat = new PrivateChat(user1, user2);
        System.out.println("Chat ID: " + pChat.getId());
        user1.showContacts();
        pChat.addMessage(new Message("Hi", user1.getId()));
        pChat.addMessage(new Message("Hello", user2.getId()));
        pChat.showMessageHistory();
    }
}
