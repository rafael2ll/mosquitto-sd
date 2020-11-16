package rafael.sd.service.impl;

import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import rafael.sd.model.base.Message;
import rafael.sd.model.base.MqttConnectionParams;
import rafael.sd.service.TempPublisher;
import rafael.sd.service.base.SimpleQueue;

public class TempPublisherImpl implements TempPublisher {
    public static final String CLIENT_ID = "JavaTemperaturePublisher";
    public static final String TOPIC = "Temperatures";

    SimpleQueue simpleQueue;

    public TempPublisherImpl(String broker) {
        this.simpleQueue = new SimpleQueue();
        simpleQueue.init(new MqttConnectionParams(broker, CLIENT_ID, new MemoryPersistence()));
    }

    @Override
    public void publish(int value) {
        simpleQueue.sendMessage(new Message("" + value, 2, TOPIC));
    }
}
