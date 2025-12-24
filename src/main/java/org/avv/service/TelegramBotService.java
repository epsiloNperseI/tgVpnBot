package org.avv.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.avv.dto.InboundDto;
import org.avv.entity.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Service
@RequiredArgsConstructor
public class TelegramBotService extends TelegramLongPollingBot {

    private final MessageService messageService;
    private final AuthService authService;
    private final CreateDtoInboundService createDtoInboundService;
    private final InboundService inboundService;

    @PostConstruct
    public void init() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long userId = messageService.saveMessage(update);
        String chatId = update.getMessage().getChatId().toString();
        String messageText = String.format("Привет %s! Я твой бот.",
                                           update.getMessage().getFrom().getFirstName());

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            if ("startVpnBot".equals(message)) {
                Session session = authService.login(userId);
                InboundDto dto = createDtoInboundService.createInboundDto();
                inboundService.createInbound(dto, session);
            } else {
                sendTextMessage(chatId, messageText);

            }
        }
    }

    private void sendTextMessage(String chatId, String message) {
        try {
            execute(new SendMessage(chatId, message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
