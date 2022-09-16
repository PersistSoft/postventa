package com.persist.postventa.entity.generic;

import com.persist.postventa.entity.base.BasePostgresEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "societies")
@Entity(name = "SocietyEntity")
@EqualsAndHashCode(callSuper = false)
public class SocietyEntity extends BasePostgresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 20, message = "The name should be {min} y maximum {max} characters")
    @Column(name="name")
    private String name;

    @Size(min = 5, max = 10, message = "The nit should be {min} y maximum {max} characters")
    @Column(name="nit")
    private String nit;

}
