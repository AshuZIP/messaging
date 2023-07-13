/**
 * 
 */
package com.ashu.jms.rabbitmq.messaging.directexchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Ashutosh.Ranjan
 *
 */
public class DirectExchangePublisher {

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
		
		channel.basicPublish("Custom-Direct-Exchange", "tv", null, new String("Hello AC from custom-direct-exchange!").getBytes());
		channel.close();
		conn.close();

	}

}
