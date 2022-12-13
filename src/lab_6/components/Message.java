package lab_6.components;

import java.util.Date;
import java.util.UUID;

public class Message {

    private final String id;
    private final String participantId;
    private final String text;
    private final Date date;

    public Message(String text, String participantId) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.date = new Date();
        this.participantId = participantId;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getParticipantId() {
        return participantId;
    }
}
