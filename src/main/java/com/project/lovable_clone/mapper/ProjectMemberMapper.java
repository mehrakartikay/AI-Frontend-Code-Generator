package com.project.lovable_clone.mapper;

import com.project.lovable_clone.DTO.Member.MemberResponse;
import com.project.lovable_clone.entity.Project;
import com.project.lovable_clone.entity.ProjectMember;
import com.project.lovable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId" , source = "id")
    @Mapping(target = "projectRole" , constant = "OWNER")
    MemberResponse toMemberResponseFromOwner(User owner);

    List<MemberResponse> toMemberResponse(List<User> user);

    @Mapping(target = "userId" , source = "user.id")
    @Mapping(target = "username" , source = "user.username")
    @Mapping(target = "name" , source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);


}
