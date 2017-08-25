package com.phonebook.options;

import com.phonebook.Person;
import com.phonebook.screens.ScreenShow;

public class NextPerson extends ScreenOption {

    ScreenShow screenShow;

    public NextPerson(ScreenShow screenShow) {
        this.screenShow = screenShow;
    }

    @Override
    public void proceed() {
        if (screenShow.getIterator().hasNext()){
            Person person = screenShow.getIterator().next();
            if(!screenShow.isDirectionRight()){
                person = screenShow.getIterator().next();
                screenShow.setDirectionRight(true);
            }
            screenShow.setPerson(person);
        }
        screenShow.proceed();
    }
}
