package org.paingan.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class EventController {
	
	@Value("${kafka.topic}")
	private String topic = "qz8x4wx7-paingan";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	 
	public void sendMessage(String msg) {
	   this.kafkaTemplate.send(topic, msg);
	   System.out.println("Sent sample message [" + msg + "] to " + topic);
	} 
	
	@KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void processMessage(String message) {
	   System.out.println("Received message "+message+" in group - group-id: " + "${spring.kafka.consumer.group-id}");
	}
}
