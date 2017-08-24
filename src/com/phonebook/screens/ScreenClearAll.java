package com.phonebook.screens;

import com.phonebook.options.ChangeScreen;
import com.phonebook.options.ClearAll;

/**
 * Created by asus on 24.08.2017.
 */
public class ScreenClearAll  extends Screen {

    public ScreenClearAll() {
        options.put(121, new ClearAll(this));
        options.put(110, new ChangeScreen( ScreenType.SCREEN_LIST));
    }
    @Override
    public void proceed() {
        System.out.println("Are you sure to clear? [y/n]");
        readData();
    }
}
