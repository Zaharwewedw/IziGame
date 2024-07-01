package Store.category.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfigurationTopic {

    @Bean
    public NewTopic newTopic () {
        return new NewTopic("person",
                1,
                (short) 1);
    }

    @Bean
    public NewTopic messagePayGamePerson () {
        return new NewTopic("PayPerson",
                1,
                (short) 1);
    }
}
