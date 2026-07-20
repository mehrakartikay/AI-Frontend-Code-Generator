package com.project.lovable_clone.DTO.Chat;

import com.project.lovable_clone.entity.ChatEvent;
import com.project.lovable_clone.enums.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse(
        Long id,
        MessageRole role,
        List<ChatEvent> events,
        String content,
        Integer tokensUsed,
        Instant createdAt
) {
}
