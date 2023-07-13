/**
 * 
 */
package com.ashu.jms.rabbitmq.messaging.fanoutexchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author Ashutosh.Ranjan
 *
 */
public class ConsumerFanoutExchange {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.newConnection();
		Channel ch = conn.createChannel();
		DeliverCallback callBack = (consumerTag, delivery) -> {
			System.out.println(new String(delivery.getBody()));
		};
		ch.basicConsume("AC", true,callBack, consumerTag -> {} );
		ch.basicConsume("Mobile", true,callBack, consumerTag -> {} );

	}

}
