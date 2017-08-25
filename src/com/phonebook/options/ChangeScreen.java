package com.phonebook.options;


import com.phonebook.screens.*;

public class ChangeScreen extends ScreenOption {

    protected ScreenType destinationScreen;

    public ChangeScreen(ScreenType destinationScreen) {
        this.destinationScreen = destinationScreen;
    }

    @Override
    public void proceed() {
        Screen destScreen = new ScreenError();
        switch(destinationScreen){
            case SCREEN_LIST:
                destScreen = new ScreenList();
            break;
            case SCREEN_EXIT:
                destScreen = new ScreenExit();
            break;
            case SCREEN_ADD_RECORD:
                destScreen = new ScreenAddRecord();
                break;
            case SCREEN_CLEAR_ALL:
                destScreen = new ScreenClearAll();
                break;
            case SCREEN_DELETE:
                destScreen = new ScreenDelete();
                break;
            case SCREEN_SHOW:
                destScreen = new ScreenShow();
                break;
        }
        destScreen.proceed();
    }
}
