package mainPkg;

public class Message {

    public int UserId, messageId;
    public String message, urgencyLvl;
    public Signeture sign;

    public Message(int UserId, int messageId, String message, String urgencyLvl, Signeture sign) {
        this.UserId = UserId;
        this.messageId = messageId;
        this.message = message;
        this.urgencyLvl = urgencyLvl;
        this.sign = sign;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrgencyLvl() {
        return urgencyLvl;
    }

    public void setUrgencyLvl(String urgencyLvl) {
        this.urgencyLvl = urgencyLvl;
    }

    public Signeture getSign() {
        return sign;
    }

    public void setSign(Signeture sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Message{" + "UserId=" + UserId + ", messageId=" + messageId + ", message=" + message + ", urgencyLvl=" + urgencyLvl + ", sign=" + sign + '}';
    }

}
