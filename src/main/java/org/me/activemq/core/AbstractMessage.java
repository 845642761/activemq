package org.me.activemq.core;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息抽象类
 * @author: chengbo
 * @date: 2015年9月10日 13:47:10
 */
public class AbstractMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date msgServerTime = new Date();  //服务器端创建此消息的时间
	
	public Date getMsgServerTime() {
		return msgServerTime;
	}
	public void setMsgServerTime(Date msgServerTime) {
		this.msgServerTime = msgServerTime;
	}
}
