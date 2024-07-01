package Store.authorization.service.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CatalogConsumerKafka {

    @KafkaListener(topics = "PayPerson")
    public void listenCatalog(String message) {
        System.out.println(message);
    }
}
