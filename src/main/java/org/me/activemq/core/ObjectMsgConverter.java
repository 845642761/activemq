package org.me.activemq.core;

import java.io.Serializable;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * 消息转换
 * @author: chengbo
 * @date: 2015年9月10日 15:18:15
 */
public class ObjectMsgConverter implements MessageConverter{

	@Override
	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		 if(message instanceof ActiveMQObjectMessage){  
             ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) message;   
            return aMsg.getObject();  
         }  
		return message;
	}

	@Override
	public Message toMessage(Object obj, Session session) throws JMSException,
			MessageConversionException {
		ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
		msg.setObject((Serializable) obj);
		return msg;
	}

}
