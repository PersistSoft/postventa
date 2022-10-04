package com.persist.postventa.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persist.postventa.generic.WarrantyDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component(value = "warrantyProducer")
public class WarrantyProducer {
    private final ObjectMapper mapper;
    private final KafkaTemplate<Long, String> kafkaTemplate;
    private String topic = "postventa-events";

    public void newWarrantyEvent(WarrantyDomain warrantyDomain){
        Long key = warrantyDomain.getId();

        try {

            String value = mapper.writeValueAsString(warrantyDomain);
            ProducerRecord<Long, String> producerRecord = this.buildProducerRecord(key, value, this.topic);

            ListenableFuture<SendResult<Long, String>> listenableFuture = kafkaTemplate.send(producerRecord);

            listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Long, String>>() {
                @Override
                public void onFailure(Throwable ex) {
                    handleFailure(key, value, ex);
                }

                @Override
                public void onSuccess(SendResult<Long, String> result) {
                    handleSuccess(key, value, result);
                }
            });
        } catch (Exception e){

        }
    }

    private void handleSuccess(Long key, String value, SendResult<Long, String> result) {
        log.info("Message was send successFully, key: {} and value {}, partitions: {} ",
                key, value, result.getRecordMetadata().partition());
    }

    private void handleFailure(Long key, String value, Throwable ex) {
        log.error("Error sending message key: {} and value {}, message: {}", key, value, ex.getMessage());
        try {
            throw ex;
        }catch (Throwable throwable) {
            log.error("Error in OnFailure {}", throwable.getMessage());
        }
    }

    private ProducerRecord<Long, String> buildProducerRecord(Long key, String value, String topic) {
        List<Header> recordHeaders = List.of(new RecordHeader("event-source", "scanner".getBytes()));
        return new ProducerRecord<Long, String>(topic, null, key, value, recordHeaders);
    }
}
