package com.company.Bot;


import com.company.UsersManager;
import com.company.forEnum.IndexMenu;
import com.company.managers.GameManeger;
import com.company.models.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Random;

public class TelegramBot extends TelegramLongPollingBot {
    private static final String API = "619644663:AAGqIkcPUKadi-YkdjeV0okwMsGBgZcMKJo";
    private static final String newname = "tachgamebot";

    //  private int indexMenu = 0;
    private int indexRemoveE = 0;
    private int indexAddE = 0;
    private int indexAddR = 0;
    private int indexRemoveR = 0;
    private String categoryAddE = " ";
    private String nameAddE = " ";
    private String manyAddE = " ";
    private String dateAddE = " ";
    private String nameRemoveE = " ";
    private String manyRemoveE = " ";
    private String dateRemoveE = " ";
    IndexMenu indexMenuEnum;


    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update : updates) {
            process(update);
        }
    }

    /**
     * @param update
     */

    @Override
    public void onUpdateReceived(Update update) {
        process(update);
    }

    /**
     * @param update
     */

    private void process(Update update) {
        if (update.hasMessage()) {
            process(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            process(update.getCallbackQuery());
        }
    }

    /**
     * @param message
     */
    private void process(Message message) {
        long chatId = message.getChatId();

        SendMessage sendMessage = new SendMessage().setChatId(chatId);

        String text = message.getText();

        String reply = text;


        if (text.equalsIgnoreCase("/start")) {
            showBotIsTyping(chatId);
            User user = UsersManager.getInstance().addUser(message);

            reply = "Total games" + user.getGamess() + "\n" + "Highscore" + user.getHighscore();
            sendMessage.setText(reply);
            execute(sendMessage);

        } else if (text.equalsIgnoreCase("/play")) {
            GameManeger.getInstance().startGame(new GameManeger.IGameCallbsck() {
                @Override
                public void onNewQuestion(int first, int second) {
                    sendMessage.setText(first + "*" + second + "=");
                    execute(sendMessage);
                }

                @Override
                public void onGaneOver() {
                    sendMessage.setText("game over");
                    execute(sendMessage);
                }
            });
        } else {
            GameManeger.getInstance().check(Integer.valueOf(text));
        }
    }


    /**
     * @param callbackQuery
     */
    private void process(CallbackQuery callbackQuery) {
// TODO: Add handling of callback
    }

    /**
     * Wrapper for execute method
     *
     * @param sendMessage {@link SendMessage} to be sent to user
     */


    private void execute(SendMessage sendMessage) {
        try {
            super.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    /**
     * Shows "typing" in bot status
     *
     * @param chatId id of the chat to respond in
     */
    private void showBotIsTyping(long chatId) {
        try {
            execute(new SendChatAction(chatId, "typing"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return newname;
    }

    @Override
    public String getBotToken() {
        return API;
    }
}
