package com.project.lovable_clone.ServiceImpl;

import com.project.lovable_clone.DTO.Chat.ChatResponse;
import com.project.lovable_clone.Repository.ChatMessageRepository;
import com.project.lovable_clone.Repository.ChatSessionRepository;
import com.project.lovable_clone.Service.ChatService;
import com.project.lovable_clone.entity.ChatMessage;
import com.project.lovable_clone.entity.ChatSession;
import com.project.lovable_clone.entity.ChatSessionId;
import com.project.lovable_clone.mapper.ChatMapper;
import com.project.lovable_clone.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final AuthUtil authUtil;
    private final ChatSessionRepository chatSessionRepository;
    private final ChatMapper chatMapper;


    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getUserId();
        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(userId, projectId)
        );

        List<ChatMessage> chatMessageList=chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }


}
