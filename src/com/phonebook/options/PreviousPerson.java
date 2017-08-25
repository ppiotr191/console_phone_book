package com.phonebook.options;

import com.phonebook.Person;
import com.phonebook.screens.ScreenShow;

public class PreviousPerson extends ScreenOption {

    ScreenShow screenShow;

    public PreviousPerson(ScreenShow screenShow) {
        this.screenShow = screenShow;
    }

    @Override
    public void proceed() {
        if (screenShow.getIterator().hasPrevious()){
            Person person = screenShow.getIterator().previous();
            if(screenShow.isDirectionRight()){
                person = screenShow.getIterator().previous();
                screenShow.setDirectionRight(false);
            }
            screenShow.setPerson(person);
        }
        screenShow.proceed();
    }
}
