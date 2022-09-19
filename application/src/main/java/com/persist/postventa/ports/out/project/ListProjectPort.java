package com.persist.postventa.ports.out.project;

import com.persist.postventa.generic.ProjectDomain;

import java.util.List;

@FunctionalInterface
public interface ListProjectPort {
    List<ProjectDomain> findAll();
}
