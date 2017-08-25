package com.phonebook.screens;

import com.phonebook.options.ChangeScreen;
import com.phonebook.options.ClearAll;
import com.phonebook.utils.Key;

public class ScreenClearAll  extends Screen {

    public ScreenClearAll() {
        options.put(Key.Y.getKeyCode(), new ClearAll(this));
        options.put(Key.N.getKeyCode(), new ChangeScreen( ScreenType.SCREEN_LIST));
    }
    @Override
    public void proceed() {
        System.out.println("Are you sure to clear? [y/n]");
        readData();
    }
}
