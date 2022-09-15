package com.persist.postventa.basic;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BasicDomain {
    @Builder.Default
    private Long id=0L;
}
