package com.example.kafkaproducer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Autowired
  HomeService homeService;

  @GetMapping("/send")
  public void sendKafkaMsg() {
    homeService.sendMsg();
  }
}
