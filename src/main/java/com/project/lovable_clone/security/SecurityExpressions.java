package com.project.lovable_clone.security;

import com.project.lovable_clone.Repository.ProjectMemberRepository;
import com.project.lovable_clone.enums.ProjectPermission;
import com.project.lovable_clone.enums.ProjectRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {

    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;

    private Boolean hasPermission(Long projectId,ProjectPermission projectPermission) {
        Long userId = authUtil.getUserId();
        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId,userId)
                .map(role -> role.getPermissions().contains(projectPermission)).
                orElse(false);
    }

    public Boolean canViewProject(Long projectId) {

        return hasPermission(projectId,ProjectPermission.VIEW);

    }
    public Boolean canEditProject(Long projectId) {

        return hasPermission(projectId,ProjectPermission.EDIT);

    }
    public Boolean canDeleteProject(Long projectId) {
        return hasPermission(projectId,ProjectPermission.DELETE);
    }

    public Boolean canManageMembers(Long projectId) {
        return hasPermission(projectId,ProjectPermission.MANAGE_MEMBERS);
    }

    public Boolean canViewMembers(Long projectId) {
        return hasPermission(projectId,ProjectPermission.VIEW_MEMBERS);
    }
}
