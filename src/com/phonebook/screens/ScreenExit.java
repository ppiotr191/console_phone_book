package com.phonebook.screens;

import com.phonebook.options.ChangeScreen;
import com.phonebook.options.Exit;

public class ScreenExit extends Screen {

    public ScreenExit() {
        options.put(121, new Exit(this));
        options.put(110, new ChangeScreen(ScreenType.SCREEN_LIST));
    }
    @Override
    public void proceed() {
        System.out.println("Are you sure to exit? [y/n]");
        readData();
    }
}
