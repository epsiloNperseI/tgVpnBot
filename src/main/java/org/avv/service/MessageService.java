package org.avv.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.avv.entity.Chat;
import org.avv.entity.Message;
import org.avv.entity.User;
import org.avv.repository.ChatRepository;
import org.avv.repository.MessageRepository;
import org.avv.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageService {

    MessageRepository repository;
    ChatRepository chatRepository;
    UserRepository userRepository;

    @Transactional
    public Long saveMessage(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return null;
        }

        org.telegram.telegrambots.meta.api.objects.Message tgMessage = update.getMessage();
        org.telegram.telegrambots.meta.api.objects.User tgUser = tgMessage.getFrom();
        org.telegram.telegrambots.meta.api.objects.Chat tgChat = tgMessage.getChat();

        User user = userRepository.findByTgUserId(tgUser.getId())
            .orElseGet(() -> {
                User newUser = new User();
                newUser.setTgUserId(tgUser.getId());
                newUser.setFirstName(tgUser.getFirstName());
                newUser.setLastName(tgUser.getLastName());
                newUser.setUsername(tgUser.getUserName());
                newUser.setIsBot(tgUser.getIsBot());
                newUser.setLanguageCode(tgUser.getLanguageCode());
                return newUser;
            });

        userRepository.save(user);

        Chat chat = chatRepository.findByTgChatId(tgChat.getId())
            .orElseGet(() -> {
                Chat newChat = new Chat();
                newChat.setTgChatId(tgChat.getId());
                newChat.setTitle(tgChat.getTitle());
                newChat.setType(tgChat.getType());
                return newChat;
            });

        chatRepository.save(chat);

        Message message = new Message();
        message.setTgMessageId(tgMessage.getMessageId().longValue());
        message.setMessageText(tgMessage.getText());
        message.setUser(user);
        message.setChat(chat);
        message.setDateCreated(LocalDateTime.now());
        repository.save(message);
        return user.getId();
    }

    @Transactional
    public void save(Message message) {
        repository.save(message);
    }
}

