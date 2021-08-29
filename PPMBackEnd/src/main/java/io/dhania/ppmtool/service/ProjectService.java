package io.dhania.ppmtool.service;

import io.dhania.ppmtool.domain.Project;
import org.springframework.stereotype.Service;


public interface ProjectService {

    Project saveOrUpdateProject(Project project);
}
