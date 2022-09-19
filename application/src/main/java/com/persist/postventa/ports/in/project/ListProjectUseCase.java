package com.persist.postventa.ports.in.project;

import com.persist.postventa.generic.ProjectDomain;

import java.util.List;

@FunctionalInterface
public interface ListProjectUseCase {
    List<ProjectDomain> findAll();
}
