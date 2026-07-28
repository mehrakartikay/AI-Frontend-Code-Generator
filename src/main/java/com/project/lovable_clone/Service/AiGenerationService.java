package com.project.lovable_clone.Service;
import com.project.lovable_clone.DTO.Chat.StreamResponse;
import reactor.core.publisher.Flux;

public interface AiGenerationService {

    Flux<StreamResponse> streamResponse(String message, Long projectId);
}
