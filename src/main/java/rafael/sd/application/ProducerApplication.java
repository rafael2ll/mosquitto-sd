package rafael.sd.application;

import rafael.sd.service.TempPublisher;
import rafael.sd.service.impl.TempPublisherImpl;

import java.security.SecureRandom;

public class ProducerApplication {
    public static void main(String[] args) throws InterruptedException {
        TempPublisher tempPublisher = new TempPublisherImpl("tcp://mqtt.eclipse.org:1883");
        while (true) {
            tempPublisher.publish(14 + new SecureRandom().nextInt(31));
            Thread.sleep(1000);
        }
    }
}
