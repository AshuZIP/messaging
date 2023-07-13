/**
 * 
 */
package com.ashu.jms.rabbitmq.messaging;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;
//import com.rabbitmq.client.AMQP.Channel;
//import com.rabbitmq.client.AMQP.Connection;
//import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Ashutosh.Ranjan
 *
 */
public class Publisher {

	/**
	 * @param args
	 * @throws TimeoutException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.newConnection();
		System.out.println(conn.getClass());
		Channel channel = conn.createChannel();
		//String message = "Hello World! for Rabbit MQ.";
		String[] messages = new String[]{"Messae 1", "message-2", "message-3", "message-4", "message-5"}; 
		for(String message: messages) {
			channel.basicPublish("", "Queue-1", null, message.getBytes());
		}
		channel.close();
		conn.close();
		
	}

}
