package lab_6.components;

import lab_6.types.StatusRequestType;

import java.util.Date;

public class AddRequest {
    User fromUser;
    User toUser;
    private Date date;
    StatusRequestType status;

    public AddRequest(User from, User to, Date date) {
        this.fromUser = from;
        this.toUser = to;
        this.date = date;
        this.status = StatusRequestType.Unread;
    }

    public StatusRequestType getStatus() {
        return status;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public Date getDate() {
        return date;
    }
}
