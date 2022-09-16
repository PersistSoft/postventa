package com.persist.postventa.generic;

import com.persist.postventa.basic.BasicDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WarrantyDomain extends BasicDomain {
    private ClientDomain client;
    private ApartmentDomain apartment;
    private Date creationDate;
}
