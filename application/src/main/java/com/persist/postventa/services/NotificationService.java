package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.ports.in.warranty.NewWarrantyNotificationUseCase;
import com.persist.postventa.ports.out.warranty.NewWarrantyNotificationPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "notificationService")
public class NotificationService implements NewWarrantyNotificationUseCase {
    private final NewWarrantyNotificationPort newWarrantyNotificationPort;

    @Override
    public WarrantyDomain send(WarrantyDomain warrantyDomain) {
        return this.newWarrantyNotificationPort.send(warrantyDomain);
    }
}
