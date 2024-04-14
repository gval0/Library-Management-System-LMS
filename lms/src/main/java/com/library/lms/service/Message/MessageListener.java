package com.library.lms.service.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

//    @JmsListener(destination = "BookUpdate")
//    public void onMessageReceived(String message) {
//        System.out.println("Received message: " + message);
//    }
}
