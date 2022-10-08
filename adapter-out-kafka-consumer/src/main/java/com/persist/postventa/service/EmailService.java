package com.persist.postventa.service;

import com.persist.postventa.generic.WarrantyDomain;

public interface EmailService {
    String sendSimpleMail(WarrantyDomain warrantyDomain);
}
