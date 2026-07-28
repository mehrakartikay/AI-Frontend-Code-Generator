package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.deploy.DeployResponse;

public interface DeploymentService {
    DeployResponse deploy(Long projectId);


}
