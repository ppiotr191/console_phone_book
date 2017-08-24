package com.phonebook.options;


import com.phonebook.screens.Screen;
import com.phonebook.screens.ScreenList;

public class Next extends ScreenOption {
    public Next(Screen screen) {
        super(screen);
    }

    @Override
    public void proceed() {
        ScreenList screenList = (ScreenList)screen;
        screenList.incrementCurrentPage(1);
        screenList.proceed();
    }
}
