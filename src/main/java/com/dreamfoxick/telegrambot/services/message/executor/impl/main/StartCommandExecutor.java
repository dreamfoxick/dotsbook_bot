package com.dreamfoxick.telegrambot.services.message.executor.impl.main;

import com.dreamfoxick.telegrambot.services.message.creator.KeyboardCreator;
import com.dreamfoxick.telegrambot.services.message.executor.impl.AbstractCommandExecutor;
import com.dreamfoxick.telegrambot.services.statecontroller.State;
import com.dreamfoxick.telegrambot.services.statecontroller.StateController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import static com.dreamfoxick.telegrambot.services.message.executor.CommandResponseText.START;
import static com.dreamfoxick.telegrambot.services.statecontroller.State.MAIN_MENU_STATE;

@Component
public class StartCommandExecutor extends AbstractCommandExecutor {
    private final StateController<Long, State> controller;

    public StartCommandExecutor(@Qualifier("stateController") StateController<Long, State> controller) {
        this.controller = controller;
    }

    @Override
    protected void updateState(long chatId) {
        controller.addIfAbsent(chatId, MAIN_MENU_STATE);
    }

    @Override
    protected String getResponseText() {
        return START.getResponseText();
    }

    @Override
    protected ReplyKeyboardMarkup getResponseKeyboard() {
        return KeyboardCreator.mainKeyboard();
    }
}
