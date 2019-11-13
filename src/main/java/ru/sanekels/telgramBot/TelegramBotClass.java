package ru.sanekels.telgramBot;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegramBotClass extends TelegramLongPollingCommandBot {
    private static final String BOT_USERNAME = "SanekEls661Bot";
    private static final String BOT_TOKEN = System.getenv("BOT_TOKEN_FIRST");

    TelegramBotClass(DefaultBotOptions botOptions) {
        super(BOT_USERNAME);
        register(new FirstCommand());
        register(new InlineKeyboardMy());
        register(new ReplyKeyboardMy());
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        if (message.getText().equals("hello")) {
            sendMessage.setText("hello, Master!");
        } else {
            sendMessage.setText("something goes wrong(");
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
