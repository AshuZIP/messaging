/**
 * 
 */
package com.ashu.messaging.rabbitmq.rabbitmq.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageBuilderSupport;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.messaging.rabbitmq.rabbitmq.entity.Person;

/**
 * @author Ashutosh.Ranjan
 *
 */

@RestController
public class TestControllerHeaders {
	
	@Autowired
	RabbitTemplate rt;
	
	@GetMapping("/test/headers-exchange/{name}")
	public String getHeaders(@PathVariable String name) throws IOException {
		
		Person  person = new Person(name, 26);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput obj = new ObjectOutputStream(bos);
		obj.writeObject(person);
		obj.flush();
		obj.close();
		
		byte[] body = bos.toByteArray();
		bos.close();
		
		Message message = MessageBuilder.withBody(body).setHeader("item1", "mobile").setHeader("item2", "ac")
				.build();
		
		rt.send("Custom-Header-Exchange", "", message);
		return "<h1>Success  {name} </h1>";
		
	}
}
