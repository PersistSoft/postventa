package com.persist.postventa.entity.generic;

import com.persist.postventa.entity.base.BasePostgresEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warranties")
@Entity(name = "WarrantyEntity")
@EqualsAndHashCode(callSuper = false)
public class WarrantyEntity extends BasePostgresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private ApartmentEntity apartment;

    @Column(name = "creation_date")
    private Date creationDate;
}
