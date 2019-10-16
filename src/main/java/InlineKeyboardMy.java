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

public class InlineKeyboardMy extends BotCommand {
    /**
     * Construct a command
     *
     * @param commandIdentifier the unique identifier of this command (e.g. the command string to
     *                          enter into chat)
     * @param description       the description of this command
     */
    private static final String commandIdentifier = "inline";
    private static final String description = "yes, sir!";

    public InlineKeyboardMy() {
        super(commandIdentifier, description);
    }

    private ReplyKeyboard getInlineKeyboardMarkup(int i) {
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
//        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
//
//        keyboardFirstRow.add(new InlineKeyboardButton("open YouTube").setUrl("https://www.youtube.com/watch?v=pdLCS1eIN8k"));
//        keyboardFirstRow.add(new InlineKeyboardButton("open VK").setUrl("vk.com"));
//        keyboard.add(keyboardFirstRow);
//
//        List<InlineKeyboardButton> keyboardSecondRow = new ArrayList<>();
//        keyboardFirstRow.add(new InlineKeyboardButton("share").setSwitchInlineQuery("it is OMG bot"));
//        keyboardFirstRow.add(new InlineKeyboardButton("hello again").setCallbackData("/hello"));
//        keyboard.add(keyboardSecondRow);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        keyboardFirstRow.add(new InlineKeyboardButton("open YouTube").setUrl("https://www.youtube.com/watch?v=pdLCS1eIN8k"));
        List<InlineKeyboardButton> keyboardSecondRow = new ArrayList<>();
        keyboardSecondRow.add(new InlineKeyboardButton("open VK").setUrl("vk.com"));
        List<InlineKeyboardButton> keyboardThirdRow = new ArrayList<>();
        keyboardThirdRow.add(new InlineKeyboardButton("share").setSwitchInlineQuery("it is OMG bot"));
        List<InlineKeyboardButton> keyboardFourthRow = new ArrayList<>();
        keyboardFourthRow.add(new InlineKeyboardButton("hello again").setCallbackData("/hello"));
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);
        keyboard.add(keyboardFourthRow);
        inlineKeyboardMarkup.setKeyboard(keyboard.subList(i + 1, i + 1).subList(1, 1));
        return inlineKeyboardMarkup;
    }

    private static List<List<InlineKeyboardButton>> inlineButtonsList() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        keyboardFirstRow.add(new InlineKeyboardButton("open YouTube").setUrl("https://www.youtube.com/watch?v=pdLCS1eIN8k"));
        List<InlineKeyboardButton> keyboardSecondRow = new ArrayList<>();
        keyboardSecondRow.add(new InlineKeyboardButton("open VK").setUrl("vk.com"));
        List<InlineKeyboardButton> keyboardThirdRow = new ArrayList<>();
        keyboardThirdRow.add(new InlineKeyboardButton("share").setSwitchInlineQuery("it is OMG bot"));
        List<InlineKeyboardButton> keyboardFourthRow = new ArrayList<>();
        keyboardFourthRow.add(new InlineKeyboardButton("hello again").setCallbackData("/hello"));
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);
        keyboard.add(keyboardFourthRow);
        inlineKeyboardMarkup.setKeyboard(keyboard.subList(0, 0).subList(0, 0));
        return keyboard;
    }

    String[] catchWords = {"YouTube", "GitHub", "share", "reply"};

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

        int buttonNumber = 0;
        for (int i = 0; i < 4; i++) {
            if (arguments != null && arguments[0].contains(catchWords[i])) {

                buttonNumber = i;
            }
        }
        SendMessage answer = new SendMessage();
        StringBuilder messageTextBuilder = new StringBuilder("inline Hello");
        answer.setChatId(chat.getId().toString());
        answer.setText(messageTextBuilder.toString());
        answer.setReplyMarkup(getInlineKeyboardMarkup(buttonNumber));
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
