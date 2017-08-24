package com.phonebook.screens;

public class ScreenError extends Screen {
    @Override
    public void proceed() {
        System.out.println("Something goes wrong ;(");
        System.exit(1);
    }
}
