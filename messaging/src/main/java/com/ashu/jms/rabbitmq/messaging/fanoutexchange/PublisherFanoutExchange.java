/**
 * 
 */
package com.ashu.jms.rabbitmq.messaging.fanoutexchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Ashutosh.Ranjan
 *
 */
public class PublisherFanoutExchange {

	/**
	 * @param args
	 * @throws TimeoutException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.newConnection();
		Channel ch = conn.createChannel();
		for(int i=0;i<10000;i++) {
			ch.basicPublish("Custom-Fanout-Exchange", "", null, new String("Hello from Fanout-Exchange!!!!").getBytes());
		}
		//new ConnectionFactory().newConnection().createChannel().basicPublish("Custom-Fanout-Exchange", "", null, new String("Hello from fanout exchange").getBytes());
		ch.close();
		conn.close();

	}

}
