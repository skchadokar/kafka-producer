package com.example.kafkaproducer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class HomeService {

  @Autowired
  KafkaTemplate kafkaTemplate;

  public void sendMsg() {

    Msg message = new Msg();

    message.setAge("38Y");
    message.setName("Satish");
    ListenableFuture<SendResult<String, Msg>> future = kafkaTemplate.send("sayHi", message);
    future.addCallback(new ListenableFutureCallback<SendResult<String, Msg>>() {
      @Override
      public void onSuccess(SendResult<String, Msg> result) {
        System.out.println(" Msg Sent Successfully");
      }

      @Override
      public void onFailure(Throwable ex) {
        System.out.println(" Failed");
      }
    });

  }
}
