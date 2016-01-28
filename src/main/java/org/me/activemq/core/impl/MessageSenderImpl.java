package org.me.activemq.core.impl;

import javax.jms.Destination;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.me.activemq.core.AbstractMessage;
import org.me.activemq.core.IMessageSender;
import org.springframework.jms.core.JmsTemplate;

public class MessageSenderImpl implements IMessageSender {

	private Logger log = Logger.getLogger(MessageSenderImpl.class);
	private JmsTemplate jmsTemplate;
	private Destination destination;
	private String topicDestinationName;
	private String queueDestinationName;
	
	@Override
	public void send(AbstractMessage msg) {
		log.info("[ **** start send message! **** ]");
		jmsTemplate.convertAndSend(destination, msg);
		log.info("[ **** send message successful! **** ]");
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}


	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public String getTopicDestinationName() {
		return topicDestinationName;
	}

	public void setTopicDestinationName(String topicDestinationName) {
		ActiveMQTopic topic = new ActiveMQTopic(topicDestinationName);
		destination = topic;
		this.topicDestinationName = topicDestinationName;
	}

	public String getQueueDestinationName() {
		return queueDestinationName;
	}

	public void setQueueDestinationName(String queueDestinationName) {
		ActiveMQQueue queue = new ActiveMQQueue(queueDestinationName);
		destination = queue;
		this.queueDestinationName = queueDestinationName;
	}
}
