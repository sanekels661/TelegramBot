import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InlineKeyboardMy extends BotCommand {

    private static final String commandIdentifier = "inline";
    private static final String description = "yes, sir!";
    private String[] catchWords = {"YouTube", "GitHub", "share", "reply"};

    public InlineKeyboardMy() {
        super(commandIdentifier, description);
    }

    private ReplyKeyboard getInlineKeyboardMarkup(String[] args) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        if (args != null && args[0].contains(catchWords[0])) {
            keyboardFirstRow.add(new InlineKeyboardButton("open YouTube cool video)").setUrl("https://www.youtube.com/watch?v=pdLCS1eIN8k"));
        }
        if (args != null && args[0].contains(catchWords[1])) {
            keyboardFirstRow.add(new InlineKeyboardButton("open GitHub telegramBot repository").setUrl("https://github.com/sanekels661/TelegramBot"));
        }
        if (args != null && args[0].contains(catchWords[2])) {
            keyboardFirstRow.add(new InlineKeyboardButton("share to friend").setSwitchInlineQuery("it is OMG bot"));
        }
        if (args != null && args[0].contains(catchWords[3])) {
            keyboardFirstRow.add(new InlineKeyboardButton("hello command").setCallbackData("/hello"));
        }
        keyboard.add(keyboardFirstRow);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage answer = new SendMessage();
        StringBuilder messageTextBuilder = new StringBuilder("inline answer");
        answer.setChatId(chat.getId().toString());
        answer.setText(messageTextBuilder.toString());
        answer.setReplyMarkup(getInlineKeyboardMarkup(arguments));
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
