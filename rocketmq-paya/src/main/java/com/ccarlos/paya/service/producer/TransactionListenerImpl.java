package com.ccarlos.paya.service.producer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ccarlos.paya.mapper.CustomerAccountMapper;
@Component
public class TransactionListenerImpl implements TransactionListener {

	@Autowired
	private CustomerAccountMapper customerAccountMapper;
	
	@Override
	public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {

		
	}

	@Override
	public LocalTransactionState checkLocalTransaction(MessageExt msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
