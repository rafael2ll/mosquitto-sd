package rafael.sd.model.base;

import org.eclipse.paho.client.mqttv3.MqttClientPersistence;

public class MqttConnectionParamsBuilder {
    private String broker;
    private String clientId;
    private MqttClientPersistence persistence;

    public MqttConnectionParamsBuilder setBroker(String broker) {
        this.broker = broker;
        return this;
    }

    public MqttConnectionParamsBuilder setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public MqttConnectionParamsBuilder setPersistence(MqttClientPersistence persistence) {
        this.persistence = persistence;
        return this;
    }

    public MqttConnectionParams create() {
        return new MqttConnectionParams(broker, clientId, persistence);
    }
}