package com.phonebook.screens;

import com.phonebook.options.ChangeScreen;
import com.phonebook.options.Exit;
import com.phonebook.utils.Key;

public class ScreenExit extends Screen {

    public ScreenExit() {
        options.put(Key.Y.getKeyCode(), new Exit(this));
        options.put(Key.N.getKeyCode(), new ChangeScreen(ScreenType.SCREEN_LIST));
    }
    @Override
    public void proceed() {
        System.out.println("Are you sure to exit? [y/n]");
        readData();
    }
}
