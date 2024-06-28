package Store.authorization.config.kafka.kafka_topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfigurationTopic {

    @Bean
    public NewTopic newTopic () {
        return new NewTopic("person",
                1,
                (short) 1);
    }

    @Bean
    public NewTopic newTopicSaveEmail () {
        return new NewTopic("personEmail",
                1,
                (short) 1);
    }

    @Bean
    public NewTopic newTopicPayGameByEmail () {
        return new NewTopic("personPayGame",
                1,
                (short) 1);
    }
}
