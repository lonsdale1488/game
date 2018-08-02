package com.company;

import com.company.uiutils.ButtonTelegram;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class Key {
    private Key ()
    {
    }
    public static InlineKeyboardMarkup key(SendMessage sendMessage)
    {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(ButtonTelegram.Bottonnew("Додати", "addE", "Переглянути", "viewE", "Забрати", "removeE"));
        sendMessage.setText("Витрати");
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
}

}
