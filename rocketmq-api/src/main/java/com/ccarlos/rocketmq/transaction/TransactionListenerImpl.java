package com.ccarlos.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

public class TransactionListenerImpl implements TransactionListener {


	@Override
	public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
		System.err.println("-------执行本地事务-------");
		String callArg = (String) arg;
		System.err.println("callArg:" + callArg);
		System.err.println("msg:" + msg);
		// tx.begin
		// 数据库的落库操作

		// tx.commit
		return null;
	}

	@Override
	public LocalTransactionState checkLocalTransaction(MessageExt msg) {
		System.err.println("-------回调消息检查-------" + msg);
		return null;
	}

}
