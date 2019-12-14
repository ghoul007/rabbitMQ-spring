# Send Message to RabbitMQ Broker. 

Add RabbitMQ dependency


```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```


A ConnectionFactory object is used by the client to make connections to the server
```
@Bean
public ConnectionFactory connectionFactory() {
    CachingConnectionFactory factory =  new CachingConnectionFactory("172.17.0.2");
    factory.setPort(5672);
    factory.setUsername("guest");
    factory.setPassword("guest");
    return factory;
}
```


Publish message
```
@Autowired
private RabbitTemplate rabbitTemplate;

rabbitTemplate.convertAndSend("MyTopicExchange", "topic", simpleMessage);
```


Receive event message

```
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMQMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
	 
		System.out.print("messgae= "+ new String(message.getBody()));
		
	}

}
```