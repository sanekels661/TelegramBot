import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class telegramBotClass extends TelegramLongPollingBot{
    private static final  String BOT_USERNAME = "SanekEls661Bot";
    private static final  String BOT_TOKEN = "833904710:AAFpe3m6_QOBQa-NQuuCV77BvgEriqzb4JU";
    public telegramBotClass(DefaultBotOptions botOptions){
        super(botOptions);
    }
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage(message.getChatId(),message.getText());
        if (update.getMessage().getText().equals("hello")){
            sendMessage.setText("hello, Master!");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        else {
            sendMessage.setText("DIE, MEATBAG!!!");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }
    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
