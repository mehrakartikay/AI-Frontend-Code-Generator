package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.auth.FileContentResponse;
import com.project.lovable_clone.DTO.project.FileNode;
import java.util.List;


public interface ProjectFileService {
    List<FileNode> getFileTree(Long projectId);


    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
