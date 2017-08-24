package com.phonebook.options;


import com.phonebook.screens.Screen;

public abstract class ScreenOption {
    protected Screen screen;

    public ScreenOption() {

    }

    public ScreenOption(Screen screen){
        this.screen = screen;
    }
    abstract public void proceed();
}
