package lab_6;

import java.util.*;

public class Participant {

    private String id;
    private String username;
    private HashMap<String, PrivateChat> privateChats = new HashMap<>();
    private ArrayList<GroupChat> groupChats = new ArrayList<>();
    private HashMap<String, Participant> contacts = new HashMap<>();
    private String status = null;


    public Participant(String username) {
        this.id = UUID.randomUUID().toString();
//        this.id = id;
        this.username = username;
    }

    public boolean sendMessageToPrivateChat(Participant toParticipant, String content) {
        PrivateChat chat = privateChats.get(toParticipant.getId());
        if (chat == null) {
            chat = new PrivateChat(this, toParticipant);
            privateChats.put(toParticipant.getId(), chat);
        }
        Message message = new Message(content);
        return chat.addMessage(message);
    }

    public boolean sendMessageToGroupChat(String groupId, String content) {
        GroupChat chat = groupChats.get(Integer.parseInt(groupId));
        if (chat != null) {
            Message message = new Message(content);
            return chat.addMessage(message);
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public String getId(){
        return id;
    }

    //
//    public void setStatus(UserStatus status) {
//        this.status = status;
//    }
//
//    public UserStatus getStatus() {
//        return status;
//    }
//
//    public boolean addContact(User user) {
//        if (contacts.containsKey(user.getId())) {
//            return false;
//        } else {
//            contacts.put(user.getId(), user);
//            return true;
//        }
//    }
//
//    public void receivedAddRequest(AddRequest req) {
//        int senderId = req.getFromUser().getId();
//        if (!receivedAddRequests.containsKey(senderId)) {
//            receivedAddRequests.put(senderId, req);
//        }
//    }
//
//    public void sentAddRequest(AddRequest req) {
//        int receiverId = req.getFromUser().getId();
//        if (!sentAddRequests.containsKey(receiverId)) {
//            sentAddRequests.put(receiverId, req);
//        }
//    }
//
//    public void removeAddRequest(AddRequest req) {
//        if (req.getToUser() == this) {
//            receivedAddRequests.remove(req);
//        } else if (req.getFromUser() == this) {
//            sentAddRequests.remove(req);
//        }
//    }
//
//    public void requestAddUser(String accountName) {
//        UserManager.getInstance().addUser(this, accountName);
//    }
//
//    public void addConversation(PrivateChat conversation) {
//        User otherUser = conversation.getOtherParticipant(this);
//        privateChats.put(otherUser.getId(), conversation);
//    }
//
//    public void addConversation(GroupChat conversation) {
//        groupChats.add(conversation);
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getAccountName() {
//        return accountName;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//}

}
