package org.paingan.boot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventConsumerServiceImpl {
	
	private static final Logger log = LoggerFactory.getLogger(EventConsumerServiceImpl.class);
	
	@Value("${kafka.topic.general}")
	private String topic = "qz8x4wx7-paingan";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	 
	public void sendMessage(String msg) {
		this.kafkaTemplate.send(topic, msg);
		System.out.println("Sent sample message [" + msg + "] to " + topic);
	} 
	
	@KafkaListener(topics = "${kafka.topic.general}", groupId = "${spring.kafka.consumer.group-id}")
	public void processMessageGeneral(String message) {
		log.debug("received content = '{}'", message.toString());
		System.out.println("Received message "+message);
	}
	
	
	@KafkaListener(topics = "${kafka.topic.audit}", groupId = "${spring.kafka.consumer.group-id}")
	public void processMessageAudit(String message) {
		log.debug("received content = '{}'", message.toString());
		System.out.println("Received message "+message);
	}
}
