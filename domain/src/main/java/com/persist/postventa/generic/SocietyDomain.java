package com.persist.postventa.generic;

import com.persist.postventa.basic.BasicDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SocietyDomain extends BasicDomain {
    private String name;
    private String nit;
}
