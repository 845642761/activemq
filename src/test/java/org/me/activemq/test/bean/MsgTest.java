package org.me.activemq.test.bean;

import java.util.Date;

import org.me.activemq.core.AbstractMessage;

/**
 * 测试消息发送
 * @author: chengbo
 * @date: 2015年9月10日 15:38:09
 */
public class MsgTest extends AbstractMessage{
	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
