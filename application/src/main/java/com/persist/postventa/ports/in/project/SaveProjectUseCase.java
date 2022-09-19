package com.persist.postventa.ports.in.project;

import com.persist.postventa.generic.ProjectDomain;

@FunctionalInterface
public interface SaveProjectUseCase {
    ProjectDomain save(ProjectCommand projectCommand);
}
