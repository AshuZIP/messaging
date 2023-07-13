/**
 * 
 */
package com.ashu.jms.rabbitmq.messaging;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;

//import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.*;

/**
 * @author Ashutosh.Ranjan
 *
 */
public class Consumer {
	
	public static int co = 0;

	/**
	 * @param args
	 * @throws TimeoutException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.newConnection();
		Channel  channel = conn.createChannel();
		
		DeliverCallback deliverCallBack = (consumerTag, delivery) -> {
//			String msg = new String(delivery.getBody());
			JSONParser parser = new JSONParser(new String(delivery.getBody()));
			System.out.println(parser);
			LinkedHashMap<String,Object> json = null;
			try {
				json = parser.parseObject();
				System.out.println("Line 43 -> "+json);
				System.out.println("Line 46 -> "+(String)json.get("From"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			co++;
			System.out.println("Message "+ co + " received -> "+json);
		};
		
		CancelCallback cancelCallBAck = consumerTag -> {
//			co++;
//			System.out.println(consumerTag.toString());
		};
		
		channel.basicConsume("Queue-1", true, deliverCallBack, cancelCallBAck);
		

	}

}
