package com.persist.postventa.adapter;

import com.persist.postventa.annotations.EventsAdapter;
import com.persist.postventa.events.WarrantyEvents;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.ports.out.warranty.NewWarrantyEventPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@EventsAdapter(value = "warrantyEventAdapter")
public class WarrantyEventAdapter implements NewWarrantyEventPort {
    private final WarrantyEvents warrantyEvents;

    @Override
    public WarrantyDomain newWarrantyEvent(WarrantyDomain warrantyDomain) {
        this.warrantyEvents.newWarrantyEvent(warrantyDomain);
        return warrantyDomain;
    }
}
