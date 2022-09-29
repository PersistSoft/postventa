package com.persist.postventa.events;

import com.persist.postventa.generic.WarrantyDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "warrantyEvents")
public class WarrantyEvents {
    public void newWarrantyEvent(WarrantyDomain warrantyDomain){
        log.info("New warranty events: {}", warrantyDomain);
    }
}
