package com.example.mit_lvyou.mapper;

import com.example.mit_lvyou.entity.Message;

import java.util.List;

public interface MessageMapper {

    public void save(Message message);

    public Message getMessageById(Long id);

    public void deleteById(Long messageId);

    public List<Message> getMessageByPair(Long senderId, Long receiverId);

}
