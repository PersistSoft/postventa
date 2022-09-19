package com.persist.postventa.ports.out.project;

import com.persist.postventa.generic.ProjectDomain;

@FunctionalInterface
public interface SaveProjectPort {
    ProjectDomain save(ProjectDomain societyDomain);
}
