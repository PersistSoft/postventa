package com.persist.postventa.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component(value = "warrantyConsumer")
public class WarrantyConsumer {

    @KafkaListener(topics = {"postventa-events"})
    public void onMessage(){

    }
}
