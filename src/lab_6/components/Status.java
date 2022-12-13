package lab_6.components;

import lab_6.types.StatusMessageType;
import lab_6.types.StatusUserType;

public class Status {
    public StatusUserType statusUser;
    StatusMessageType statusMessage;

    public Status(StatusUserType statusUser, StatusMessageType statusMessage){
        this.statusUser = statusUser;
        this.statusMessage = statusMessage;
    }

    public StatusUserType getStatusUser() {
        return statusUser;
    }

    public StatusMessageType getStatusMessage() {
        return statusMessage;
    }
}
