package com.project.lovable_clone.mapper;

import com.project.lovable_clone.DTO.Chat.ChatResponse;
import com.project.lovable_clone.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
