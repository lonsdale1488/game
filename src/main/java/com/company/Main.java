package com.company;

import com.company.Bot.TelegramBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot ( new TelegramBot());

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        // write your code here
    }
}


