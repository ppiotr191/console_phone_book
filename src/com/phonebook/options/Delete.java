package com.phonebook.options;

import com.phonebook.PhoneBook;
import com.phonebook.screens.ScreenType;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Delete extends ScreenOption{

    private AtomicInteger idToDelete;

    public Delete(AtomicInteger idToDelete) {
        this.idToDelete = idToDelete;
    }

    @Override
    public void proceed() {
        PhoneBook.getInstance().getPersons().removeIf(p -> p.getId().intValue() == idToDelete.get());
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
