package io.dhania.ppmtool.service.impl;

import io.dhania.ppmtool.domain.Project;
import io.dhania.ppmtool.repository.ProjectRepository;
import io.dhania.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveOrUpdateProject(Project project) {
        return projectRepository.save(project);
    }
}
