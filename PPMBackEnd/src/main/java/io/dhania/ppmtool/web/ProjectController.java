package io.dhania.ppmtool.web;

import io.dhania.ppmtool.domain.Project;
import io.dhania.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping()
    public ResponseEntity<Project> saveProject(@RequestBody Project project){

        return new ResponseEntity<>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }
}