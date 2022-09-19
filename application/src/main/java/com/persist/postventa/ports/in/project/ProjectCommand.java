package com.persist.postventa.ports.in.project;

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
public class ProjectCommand extends BasicDomain {
    private String name;
    private String address;
    private Long societyId;
}
