package com.persist.postventa.adapter;

import com.persist.postventa.annotations.EventsAdapter;
import com.persist.postventa.producer.WarrantyProducer;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.ports.out.warranty.NewWarrantyProducerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@EventsAdapter(value = "warrantyProducerAdapter")
public class WarrantyProducerAdapter implements NewWarrantyProducerPort {
    private final WarrantyProducer warrantyProducer;

    @Override
    public WarrantyDomain newWarrantyEvent(WarrantyDomain warrantyDomain) {
        this.warrantyProducer.newWarrantyEvent(warrantyDomain);
        return warrantyDomain;
    }
}
