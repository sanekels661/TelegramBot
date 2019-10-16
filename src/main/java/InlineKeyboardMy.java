import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardMy extends BotCommand {
    /**
     * Construct a command
     *
     * @param commandIdentifier the unique identifier of this command (e.g. the command string to
     *                          enter into chat)
     * @param description       the description of this command
     */
    public InlineKeyboardMy(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }
    private ReplyKeyboard getInlineKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();

        keyboardFirstRow.add(new InlineKeyboardButton("only text").setSwitchInlineQueryCurrentChat("text"));
        keyboardFirstRow.add(new InlineKeyboardButton("only text").setSwitchInlineQueryCurrentChat("text2"));
        keyboard.add(keyboardFirstRow);

        List<InlineKeyboardButton> keyboardSecondRow = new ArrayList<>();
        keyboardFirstRow.add(new InlineKeyboardButton("share").setSwitchInlineQuery("it is super bot"));
        keyboardFirstRow.add(new InlineKeyboardButton("next").setCallbackData("next"));
        keyboard.add(keyboardSecondRow);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

    }
}
