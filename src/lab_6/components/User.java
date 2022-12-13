package lab_6.components;

import lab_6.components.conversation.GroupChat;
import lab_6.components.conversation.PrivateChat;
import lab_6.types.StatusMessageType;
import lab_6.types.StatusRequestType;
import lab_6.types.StatusUserType;

import java.util.*;

public class User {

    private Status status = new Status(StatusUserType.Offline, StatusMessageType.Unread);
    private final String id;
    private final String username;
    private final HashMap<String, PrivateChat> privateChats = new HashMap<>();
    private final ArrayList<GroupChat> groupChats = new ArrayList<>();
    private final HashMap<String, User> contacts = new HashMap<>();
    private final HashMap<String, AddRequest> addRequests = new HashMap<>();

    public User(String username) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

  public boolean approveRequest(User sender){
      String senderId = sender.getId();
      if (!addRequests.containsKey(senderId)) {
          AddRequest req = new AddRequest(sender, this, new Date());
          req.status = StatusRequestType.Approved;
          addRequests.put(senderId, req);
          status.statusUser = StatusUserType.Online;
          return true;
      }
      return false;
  }

  public boolean denyRequest(User sender){
      String senderId = sender.getId();
      if (!addRequests.containsKey(senderId)) {
          AddRequest req = new AddRequest(sender, this, new Date());
          req.status = StatusRequestType.Denied;
          status.statusUser = StatusUserType.Online;
          addRequests.put(senderId, req);
          return true;
      }
      return false;
  }


    public boolean sendMessageToPrivateChat(User toUser, String content) {
        PrivateChat chat = privateChats.get(toUser.getId());
        if (chat == null) {
            chat = new PrivateChat(this, toUser);
            privateChats.put(toUser.getId(), chat);
        }
        Message message = new Message(content, getId());
        status.statusUser = StatusUserType.Online;
        return chat.addMessage(message);
    }

    public boolean sendMessageToGroupChat(GroupChat chat, String content) {
        Message message = new Message(content, getId());
        status.statusUser = StatusUserType.Online;
        return chat.addMessage(message);
    }

    public void addConversation(GroupChat conversation) {
        groupChats.add(conversation);
    }

    public boolean addContact(User user) {
        if (contacts.containsKey(user.getId())) {
            return false;
        } else {
            contacts.put(user.getId(), user);
//            status.statusUser = StatusUserType.Online;
            return true;
        }
    }

    public boolean removeContact(User user){
        status.statusUser = StatusUserType.Online;
        if (contacts.containsKey(user.getId())) {
            return false;
        } else {
            contacts.remove(user.getId(), user);
            return true;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, AddRequest> getAddRequests() {
        return addRequests;
    }
    //    public HashMap<String, PrivateChat> getPrivateChats() {
//        return privateChats;
//    }
//
//    public ArrayList<GroupChat> getGroupChats() {
//        return groupChats;
//    }
//
//    public HashMap<String, Participant> getContacts() {
//        return contacts;
//    }

    public void showContacts() {
        System.out.println("Contacts of " + username + ": ");
        for (User contact : contacts.values()) {
            System.out.println(contact.username);
        }
    }

    public void showGroupChats() {
        System.out.println("GroupChat of " + username + ": ");
        for (GroupChat groupChat : groupChats) {
            System.out.println(groupChat.getTittle());
        }
    }

    public void showPrivateChats() {
        System.out.println("PrivateChats of " + username + ": ");
        for (PrivateChat chat : privateChats.values()) {
            System.out.println(chat.getId());
        }
    }
}
