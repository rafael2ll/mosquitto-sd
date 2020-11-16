package rafael.sd.service.impl;

import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rafael.sd.model.base.MqttConnectionParams;
import rafael.sd.service.TempConsumer;
import rafael.sd.service.base.SimpleQueue;

public class TempConsumerImpl implements TempConsumer {
    private static final Logger logger = LoggerFactory.getLogger(TempConsumerImpl.class);


    public static final String CLIENT_ID = "JavaTemperatureConsumer";
    public static final String TOPIC = "Temperatures";

    SimpleQueue simpleQueue;

    public TempConsumerImpl(String broker) {
        this.simpleQueue = new SimpleQueue();
        simpleQueue.init(new MqttConnectionParams(broker, CLIENT_ID, new MemoryPersistence()));
    }

    @Override
    public void consume() {
        simpleQueue.subscribe(TOPIC, (topic, message) -> {
            logger.info("Temperature: {}", new String(message.getPayload()));
        });
    }
}
