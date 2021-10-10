package io.dhania.ppmtool.web;

import io.dhania.ppmtool.domain.Project;
import io.dhania.ppmtool.service.ProjectService;
import io.dhania.ppmtool.service.impl.MapValidatiobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidatiobService validatiobService;

    @PostMapping()
    public ResponseEntity<?> saveProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> map= validatiobService.mapValidationService(result);
        if (map != null) return map;

        return new ResponseEntity<>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }
}
