package Store.authorization.service.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CatalogConsumerKafka {

    @KafkaListener(topics = "catalog", groupId = "consumer_catalog")
    public void listenCatalog(String message) {

    }
}
