package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.Chat.ChatResponse;

import java.util.List;

public interface ChatService {

    List<ChatResponse> getProjectChatHistory(Long projectId);

}
