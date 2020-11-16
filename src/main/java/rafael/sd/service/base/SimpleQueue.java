package rafael.sd.service.base;

import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rafael.sd.model.base.Message;
import rafael.sd.model.base.MqttConnectionParams;

public class SimpleQueue {
    private static final Logger logger = LoggerFactory.getLogger(SimpleQueue.class);

    MqttClient client;

    public void init(MqttConnectionParams connectOptions) {
        try {
            client = new MqttClient(connectOptions.getBroker(), connectOptions.getClientId(), connectOptions.getPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + connectOptions.getBroker());
            client.connect(connOpts);
            System.out.println("Connected");
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    public void sendMessage(Message message) {

        try {
            System.out.println("Publishing message: " + message.getContent());
            MqttMessage msg = new MqttMessage(message.getContent().getBytes());
            msg.setQos(msg.getQos());
            client.publish(message.getTopic(), msg);
            System.out.println("Message published on "+ message.getTopic());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic, IMqttMessageListener messageListener) {
        try {
            client.subscribeWithResponse(topic, messageListener);
            System.out.println("Subscribed on " + topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            client.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}
