package com.example.mit_lvyou.service;

import com.example.mit_lvyou.entity.Message;
import com.example.mit_lvyou.entity.dto.MessageSaveReq;
import com.example.mit_lvyou.mapper.MessageMapper;
import com.example.mit_lvyou.util.CopyUtil;
import com.example.mit_lvyou.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private SnowFlake snowFlake;

    //通过消息Id找到消息
    public Message getMessageById(Long messageId){
        Message messageById = messageMapper.getMessageById(messageId);
        return messageById;
    }

    //通过消息Id找到消息
    public List<Message> getMessageList(Long senderId, Long receiverId){
        List<Message> messageList = messageMapper.getMessageByPair(senderId, receiverId);
        return messageList;
    }

    //存储消息
    public void save(MessageSaveReq req){
        Message message = CopyUtil.copy(req, Message.class);

        if (ObjectUtils.isEmpty(message.getId())){
            long messageId = snowFlake.nextId();
            message.setId(messageId);
        }
        message.setTime(new Timestamp(new Date().getTime()));
        messageMapper.save(message);
    }


    //删除消息
    public void deleteById(Long messageId){
        LOG.info("删除消息id：{}",messageId);
        messageMapper.deleteById(messageId);
    }
}
