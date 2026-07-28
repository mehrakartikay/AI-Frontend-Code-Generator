package com.project.lovable_clone.Controller;

import com.project.lovable_clone.DTO.auth.FileContentResponse;
import com.project.lovable_clone.DTO.project.FileNode;
import com.project.lovable_clone.DTO.project.FileTreeResponse;
import com.project.lovable_clone.Service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
public class FileController {


    private final ProjectFileService fileService;

    @GetMapping
    public ResponseEntity<FileTreeResponse> getFileTree(@PathVariable Long projectId) {

        return ResponseEntity.ok(fileService.getFileTree(projectId));
    }

    @GetMapping("/content") // /src/hooks/get-user-hook.jsx
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId,
                                                       @RequestParam String path){

        return ResponseEntity.ok(fileService.getFileContent(projectId, path));
    }

}
