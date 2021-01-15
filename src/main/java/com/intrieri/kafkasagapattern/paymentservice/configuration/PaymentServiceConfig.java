package com.intrieri.kafkasagapattern.paymentservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.intrieri.kafkasagapattern.model.evt.OrderEvent;
import com.intrieri.kafkasagapattern.model.evt.PaymentEvent;
import com.intrieri.kafkasagapattern.paymentservice.eventhandlers.OrderEventProcessorService;

import java.util.function.Function;

@Configuration
public class PaymentServiceConfig {

    @Autowired
    private OrderEventProcessorService orderEventProcessorService;

    @Bean
    public Function<OrderEvent, PaymentEvent> orderEventProcessor(){
        return orderEventProcessorService::processOrderEvent;
    }

}
