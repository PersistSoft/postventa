package com.persist.postventa.entity.generic;

import com.persist.postventa.entity.base.BasePostgresEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apartments")
@Entity(name = "ApartmentEntity")
@EqualsAndHashCode(callSuper = false)
public class ApartmentEntity extends BasePostgresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 50, message = "The name should be {min} y maximum {max} characters")
    @Column(name="name")
    private String name;

    @Size(min = 5, max = 10, message = "The status should be {min} y maximum {max} characters")
    @Column(name="status")
    private String status;

    @Column(name="delivery_date")
    private Date deliveryDate;
}
