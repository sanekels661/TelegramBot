
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.telegram.telegrambots.meta.generics.BotOptions;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//            botOptions.setProxyHost("34.67.53.141");
//            botOptions.setProxyPort(8080);
//            botOptions.setProxyType(DefaultBotOptions.ProxyType.HTTP);
            telegramBotsApi.registerBot(new telegramBotClass(botOptions));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
