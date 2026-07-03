package com.project.lovable_clone.Service;
import com.project.lovable_clone.DTO.Member.InviteMemberRequest;


import com.project.lovable_clone.DTO.Member.MemberResponse;
import com.project.lovable_clone.DTO.Member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
