package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.project.ProjectResponse;
import com.project.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.project.lovable_clone.DTO.project.ProjectRequest;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getUserProjectById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);
}
