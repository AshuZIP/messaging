/**
 * 
 */
package com.ashu.jms.rabbitmq.messaging.directexchange;

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
public class ConsumerDirectExchange {

	/**
	 * @param args
	 * @throws TimeoutException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.newConnection();
		Channel channel = conn.createChannel();
		
		DeliverCallback deliverCallback= (consumerTag, delivery)->{
			System.out.println(new String(delivery.getBody()));
		};
		
		String[] exchanges = {"AC", "TV", "Mobile"};
		
		for(String exchange:exchanges) {
			channel.basicConsume(exchange, true, deliverCallback, (consumerTag)->{});
		}

	}

}
