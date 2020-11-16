package rafael.sd.model.base;

public class Message {
    String content;
    int qos;
    String topic;

    public Message(String content, int qos, String topic) {
        this.content = content;
        this.qos = qos;
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public int getQos() {
        return qos;
    }

    public String getTopic() {
        return topic;
    }
}
