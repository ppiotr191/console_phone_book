package com.phonebook.options;

import com.phonebook.screens.Screen;

public class Exit extends ScreenOption {

    public Exit(Screen screen) {
        super(screen);
    }

    @Override
    public void proceed() {
        System.exit(0);
    }
}
