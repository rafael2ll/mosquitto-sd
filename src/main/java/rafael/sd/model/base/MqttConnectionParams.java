package rafael.sd.model.base;

import org.eclipse.paho.client.mqttv3.MqttClientPersistence;

public class MqttConnectionParams {
    String broker;

    String clientId;
    MqttClientPersistence persistence;

    public MqttConnectionParams(String broker, String clientId, MqttClientPersistence persistence) {
        this.broker = broker;
        this.clientId = clientId;
        this.persistence = persistence;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public MqttClientPersistence getPersistence() {
        return persistence;
    }

    public void setPersistence(MqttClientPersistence persistence) {
        this.persistence = persistence;
    }
}
