package com.ccarlos.rocketmq.transaction;


import com.ccarlos.rocketmq.constants.Const;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

public class TransactionProducer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, InterruptedException {
        TransactionMQProducer producer = new TransactionMQProducer
                ("text_tx_producer_group_name");
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("text_tx_producer_group_name" + "-check-thread");
                        return thread;
                    }
                });
        producer.setNamesrvAddr(Const.NAMESRV_ADDR_MASTER_SLAVE);
        producer.setExecutorService(executorService);

        // 这个对象主要做两件事情 第一件事情就是异步地执行本地事务 第二件事情就是做回查
        TransactionListener transactionListener = new TransactionListenerImpl();
        producer.setTransactionListener(transactionListener);
        producer.start();

        Message message = new Message("test_tx_topic", "TagA", "Key",
                ("Hello Rocketmq For TX!").getBytes(RemotingHelper.DEFAULT_CHARSET));
        producer.sendMessageInTransaction(message, "我是回调的参数");

        Thread.sleep(Integer.MAX_VALUE);
//        producer.shutdown();

    }


}
