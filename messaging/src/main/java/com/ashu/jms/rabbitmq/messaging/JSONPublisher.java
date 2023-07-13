/**
 * 
 */
package com.ashu.jms.rabbitmq.messaging;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Ashutosh.Ranjan
 *
 */
public class JSONPublisher {

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
		
		JSONObject json = new JSONObject();
		json.put("From", "Ashutosh");
		json.put("Date", "29/05/2023");
		json.put("Message", "Hi to the receiver from the rabbit mq!");
		json.put("To", "To anyone who receives it.");
		
		channel.basicPublish("", "Queue-1", null, json.toString().getBytes());
		channel.close();
		conn.close();
	}

}
