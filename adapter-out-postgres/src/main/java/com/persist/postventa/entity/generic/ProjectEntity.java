package com.persist.postventa.entity.generic;

import com.persist.postventa.entity.base.BasePostgresEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
@Entity(name = "ProjectEntity")
@EqualsAndHashCode(callSuper = false)
public class ProjectEntity extends BasePostgresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 120, message = "The name should be {min} y maximum {max} characters")
    @Column(name="name")
    private String name;

    @Size(min = 10, max = 50, message = "The nit should be {min} y maximum {max} characters")
    @Column(name="address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "society_id")
    private SocietyEntity society;
}
