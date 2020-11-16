package rafael.sd.application;

import rafael.sd.service.TempConsumer;
import rafael.sd.service.impl.TempConsumerImpl;

public class ConsumerApplication {

    public static void main(String[] args) throws InterruptedException {
        TempConsumer tempConsumer = new TempConsumerImpl("tcp://mqtt.eclipse.org:1883");
        tempConsumer.consume();
    }
}
