package com.persist.postventa.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.ports.in.warranty.NewWarrantyNotificationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WarrantyConsumerAdapter {
    private final ObjectMapper objectMapper;
    private final NewWarrantyNotificationUseCase newWarrantyNotificationUseCase;

    @KafkaListener(topics = {"postventa-events"}, groupId = "postventa-events-listener-group")
    public void notificationWarranty(ConsumerRecord<Long, String> consumerRecord) throws JsonProcessingException {
        WarrantyDomain warrantyDomain = this.objectMapper.readValue(consumerRecord.value(), WarrantyDomain.class);
        this.newWarrantyNotificationUseCase.send(warrantyDomain);
    }
}
