/**
 * 
 */
package com.ashu.jms.rabbitmq.messaging;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author Ashutosh.Ranjan
 *
 */
public class Consumer2 {
	
	public static int co=0;

	/**
	 * @param args
	 * @throws TimeoutException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String msg = new String(delivery.getBody());
			co++;
			System.out.println("Message "+ co + " received -> "+msg);
		};
		
		CancelCallback cancelCallBack = (callBack) -> {

		};
		
		channel.basicConsume("Queue-1", true, deliverCallback, cancelCallBack);

	}

}
