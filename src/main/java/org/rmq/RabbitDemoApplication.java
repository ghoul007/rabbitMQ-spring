package org.rmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitDemoApplication implements CommandLineRunner {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
//	@Bean
//	public ConnectionFactory connectionFactory() {
//		CachingConnectionFactory factory =  new CachingConnectionFactory("172.17.0.2");
//		factory.setPort(5672);
//		factory.setUsername("guest");
//		factory.setPassword("guest");
//		return factory;
//	}
//	
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleMessage simpleMessage  = new SimpleMessage();
		simpleMessage.setName("firstName");
		simpleMessage.setDescription("first description");
//		rabbitTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);
		
		// this is example to publish message ( you can use it  for a different project )"
		rabbitTemplate.convertAndSend("MyTopicExchange", "topic", simpleMessage);
	}

}
