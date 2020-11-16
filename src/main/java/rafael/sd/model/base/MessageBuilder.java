package rafael.sd.model.base;

public class MessageBuilder {
    private String content;
    private int qos;
    private String broker;

    public MessageBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public MessageBuilder setQos(int qos) {
        this.qos = qos;
        return this;
    }

    public MessageBuilder setBroker(String broker) {
        this.broker = broker;
        return this;
    }

    public Message create() {
        return new Message(content, qos, broker);
    }
}