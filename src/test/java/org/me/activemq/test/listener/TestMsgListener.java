package org.me.activemq.test.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.apache.log4j.Logger;
import org.me.activemq.test.bean.MsgTest;

public class TestMsgListener implements MessageListener {
	private Logger log = Logger.getLogger(TestMsgListener.class);

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			try {
				log.info("[ **** receive a message **** ]");
				MsgTest msgTest=(MsgTest)((ObjectMessage)message).getObject();
				log.info("[ **** msgTest : name ==>"+msgTest.getName()+" value ==>"+msgTest.getValue()+" Date ==>"+msgTest.getDate()+" **** ]");
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
