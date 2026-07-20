package com.project.lovable_clone.Service;
import reactor.core.publisher.Flux;

public interface AiGenerationService {

    Flux<String> streamResponse(String message, Long projectId);
}
