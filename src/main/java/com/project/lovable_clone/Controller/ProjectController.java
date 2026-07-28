package com.project.lovable_clone.Controller;

import com.project.lovable_clone.DTO.deploy.DeployResponse;
import com.project.lovable_clone.DTO.project.ProjectRequest;
import com.project.lovable_clone.DTO.project.ProjectResponse;
import com.project.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.project.lovable_clone.Service.DeploymentService;
import com.project.lovable_clone.Service.ProjectService;
import com.project.lovable_clone.security.AuthUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {


    private final ProjectService projectService;

    private final DeploymentService deploymentService;



    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponse>> getMyProjects() {

        return ResponseEntity.ok(projectService.getUserProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectSummaryResponse> getProjectById(@PathVariable Long id) {

        return ResponseEntity.ok(projectService.getUserProjectById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody @Valid ProjectRequest request) {

        return ResponseEntity.ok(projectService.updateProject(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {

        projectService.softDelete(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{id}/deploy")
    public ResponseEntity<DeployResponse> deployProject(@PathVariable Long id) {
        return ResponseEntity.ok(deploymentService.deploy(id));
    }

}
