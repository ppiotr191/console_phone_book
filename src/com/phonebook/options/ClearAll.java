package com.phonebook.options;


import com.phonebook.PhoneBook;
import com.phonebook.screens.Screen;
import com.phonebook.screens.ScreenType;

import java.io.IOException;

/**
 * Created by asus on 24.08.2017.
 */
public class ClearAll extends ScreenOption {

    public ClearAll(Screen screen) {
        super(screen);
    }

    @Override
    public void proceed() {
        PhoneBook.getInstance().getPersons().clear();
        try{
            PhoneBook.getInstance().saveToCsv();
        }
        catch(IOException e){
            System.out.println("Cannot save to database.");
        }
        ScreenOption option = new ChangeScreen(ScreenType.SCREEN_LIST);
        option.proceed();
    }
}
