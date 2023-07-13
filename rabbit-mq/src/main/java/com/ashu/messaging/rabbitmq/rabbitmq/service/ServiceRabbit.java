/**
 * 
 */
package com.ashu.messaging.rabbitmq.rabbitmq.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.ashu.messaging.rabbitmq.rabbitmq.entity.Person;

/**
 * @author Ashutosh.Ranjan
 *
 */

@Service
public class ServiceRabbit {
	
//	@RabbitListener(queues = "Mobile")
//	public void messages(Person person) {
//		System.out.println(person.getName());
//		System.out.println(person.getAge());
//	}
	
	@RabbitListener(queues = "Mobile")
	public void messages(byte[] message) throws ClassNotFoundException, IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(message);
		ObjectInput inp = new ObjectInputStream(bis);
		Person person = (Person) inp.readObject();
		System.out.println(person.getName() + " " + person.getAge());
	}
}
