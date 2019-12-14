package org.rmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMQMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
	 
		System.out.print("messgae= "+ new String(message.getBody()));
		
	}

}
