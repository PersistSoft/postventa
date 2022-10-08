package com.persist.postventa.adapter;

import com.persist.postventa.annotations.ConsumerAdapter;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.ports.out.warranty.NewWarrantyNotificationPort;
import com.persist.postventa.service.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@ConsumerAdapter(value = "notificationServiceAdapter")
public class NotificationServiceAdapter implements NewWarrantyNotificationPort {
    private final EmailServiceImpl emailServiceImpl;
    @Override
    public WarrantyDomain send(WarrantyDomain warrantyDomain) {
        this.emailServiceImpl.sendSimpleMail(warrantyDomain);
        return warrantyDomain;
    }
}
