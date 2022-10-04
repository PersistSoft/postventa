package com.persist.postventa.adapter;

import com.persist.postventa.annotations.EventsAdapter;
import com.persist.postventa.generic.WarrantyDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@RequiredArgsConstructor
@EventsAdapter(value = "warrantyConsumerAdapter")
public class WarrantyConsumerAdapter {

    @KafkaListener(topics = {"postventa-events"})
    public WarrantyDomain notificationWarranty(WarrantyDomain warrantyDomain) {

        return warrantyDomain;
    }
}
