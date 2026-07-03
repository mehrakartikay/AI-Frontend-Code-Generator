package com.project.lovable_clone.ServiceImpl;

import com.project.lovable_clone.DTO.auth.FileContentResponse;
import com.project.lovable_clone.DTO.project.FileNode;
import com.project.lovable_clone.Service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
