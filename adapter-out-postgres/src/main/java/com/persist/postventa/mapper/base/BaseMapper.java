package com.persist.postventa.mapper.base;

import java.util.List;

public interface BaseMapper<E,D> {
	D toDomain(E e);
	E toEntity(D D);
	List<D> toDomains(List<E> e);
	List<E> toEntities(List<D> d);
}
