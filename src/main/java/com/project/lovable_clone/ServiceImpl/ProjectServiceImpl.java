package com.project.lovable_clone.ServiceImpl;

import com.project.lovable_clone.DTO.project.ProjectRequest;
import com.project.lovable_clone.DTO.project.ProjectResponse;
import com.project.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.project.lovable_clone.Error.ResourceNotFoundException;
import com.project.lovable_clone.Repository.ProjectMemberRepository;
import com.project.lovable_clone.Repository.ProjectRepository;
import com.project.lovable_clone.Repository.UserRepository;
import com.project.lovable_clone.Service.ProjectService;
import com.project.lovable_clone.entity.Project;
import com.project.lovable_clone.entity.ProjectMember;
import com.project.lovable_clone.entity.ProjectMemberId;
import com.project.lovable_clone.entity.User;
import com.project.lovable_clone.enums.ProjectRole;
import com.project.lovable_clone.mapper.ProjectMapper;
import com.project.lovable_clone.security.AuthUtil;
import com.project.lovable_clone.security.SecurityExpressions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;
    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;


    @Override
    public List<ProjectSummaryResponse> getUserProjects() {

        Long userId = authUtil.getUserId();

        return projectMapper.toListOfProjectSummaryResponse(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getUserProjectById(Long projectId) {

        Long userId = authUtil.getUserId();

        Project project = getAccessibleProjectById(projectId,userId);



        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getUserId();


//        User owner = userRepository.findById(userId).orElseThrow(
//                ()-> new ResourceNotFoundException("User",userId.toString())
//        );

        User owner = userRepository.getReferenceById(userId);
        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();
        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);

    }

    @Override
    @PreAuthorize("@security.canEditProject(#id)")
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Long userId = authUtil.getUserId();
        Project project = getAccessibleProjectById(id, userId);

        project.setName(request.name());
        projectRepository.save(project);


        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long id) {
        Long userId = authUtil.getUserId();
        Project project = getAccessibleProjectById(id, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);


    }

    //INTERNAL FUNCTION
    public Project getAccessibleProjectById(Long projectId,Long userId) {
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow(
                ()-> new ResourceNotFoundException("Project",projectId.toString())
        );
    }
}
