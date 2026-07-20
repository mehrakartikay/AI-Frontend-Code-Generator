package com.project.lovable_clone.mapper;


import com.project.lovable_clone.DTO.project.FileNode;
import com.project.lovable_clone.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNodes(List<ProjectFile> projectFileList);
}
