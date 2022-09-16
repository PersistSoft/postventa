package com.persist.postventa.entity.generic;

import com.persist.postventa.entity.base.BasePostgresEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
@Entity(name = "ClientEntity")
@EqualsAndHashCode(callSuper = false)
public class ClientEntity extends BasePostgresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 50, message = "The name should be {min} y maximum {max} characters")
    @Column(name="name")
    private String name;

    @Size(min = 5, max = 50, message = "The last name should be {min} y maximum {max} characters")
    @Column(name="last_name")
    private String lastName;

    @Size(min = 10, max = 15, message = "The phone should be {min} y maximum {max} characters")
    @Column(name="phone")
    private String phone;

    @Size(min = 5, max = 50, message = "The email should be {min} y maximum {max} characters")
    @Column(name="email")
    private String email;
}
