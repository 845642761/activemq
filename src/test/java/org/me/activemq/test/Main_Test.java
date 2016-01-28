package org.me.activemq.test;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.me.activemq.core.IMessageSender;
import org.me.activemq.test.bean.MsgTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml","classpath:spring-activeMQ.xml","classpath:spring-activeMQ_Test.xml"})
public class Main_Test {

	@Resource
	private IMessageSender messgeSender;

	/**
	 * 消息发送
	 * @param: message
	 * @return: false:失败  true:成功
	 * @author: chengbo
	 * @date: 2016年1月28日 11:05:48
	 */
	@Test
	public void sendMessage() {
		String message = "测试";
		MsgTest msg=new MsgTest();
		msg.setName(message);
		msg.setValue(message);
		msg.setDate(new Date());
		messgeSender.send(msg);
	}
}
