package com.persist.postventa.ports.in;

import com.persist.postventa.generic.ProjectDomain;

import java.util.List;

@FunctionalInterface
public interface ListProjectUseCase {
    List<ProjectDomain> findAll();
}
