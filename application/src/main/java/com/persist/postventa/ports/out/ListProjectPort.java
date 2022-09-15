package com.persist.postventa.ports.out;

import com.persist.postventa.generic.ProjectDomain;

import java.util.List;

@FunctionalInterface
public interface ListProjectPort {
    List<ProjectDomain> findAll();
}
