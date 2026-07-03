package com.project.lovable_clone.mapper;

import com.project.lovable_clone.DTO.project.ProjectResponse;
import com.project.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.project.lovable_clone.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    @Mapping(source = "name" , target = "projectName")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);




}
