///**
// * 
// */
//package com.ashu.messaging.rabbitmq.rabbitmq.controller;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ashu.messaging.rabbitmq.rabbitmq.entity.Person;
//
///**
// * @author Ashutosh.Ranjan
// *
// */
//
//@RestController
//public class TestController {
//	
//	@Autowired
//	RabbitTemplate rbtTemplate;
//	
//	@GetMapping("/test/{name}")
//	public String test(@PathVariable String name) {
//		Person person = new Person(name, 26);
//		rbtTemplate.convertAndSend("Mobile", person);
//		rbtTemplate.convertAndSend("Custom-Direct-Exchange", "mobile", person);
//		rbtTemplate.convertAndSend("Custom-Direct-Exchange", "tv", person);
//		rbtTemplate.convertAndSend("Custom-Fanout-Exchange", "", person);
//		rbtTemplate.convertAndSend("Custom-Topic-Exchange", "tv.mobile.ac", person);
//		return "Success";
//	}
//}
