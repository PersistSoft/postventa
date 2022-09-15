package com.persist.postventa.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericPostgresRepository<T, ID> extends JpaRepository<T, ID> {
}
