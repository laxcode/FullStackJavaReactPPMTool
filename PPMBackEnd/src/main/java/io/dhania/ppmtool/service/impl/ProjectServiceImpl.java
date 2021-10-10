package io.dhania.ppmtool.service.impl;

import io.dhania.ppmtool.domain.Project;
import io.dhania.ppmtool.repository.ProjectRepository;
import io.dhania.ppmtool.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveOrUpdateProject(Project project) {
        /*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        for (ConstraintViolation<Project> violation : validator.validate(project)) {
            log.error(violation.getMessage());
        }*/

        return projectRepository.save(project);
    }
}
