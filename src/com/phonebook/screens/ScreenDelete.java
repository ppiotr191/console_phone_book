package com.phonebook.screens;

import com.phonebook.Person;
import com.phonebook.PhoneBook;
import com.phonebook.options.ChangeScreen;
import com.phonebook.options.Delete;
import com.phonebook.options.ScreenOption;
import com.phonebook.utils.Key;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ScreenDelete extends Screen {

    protected AtomicInteger idToDelete;

    public ScreenDelete() {
        idToDelete = new AtomicInteger(0);
        options.put(Key.Y.getKeyCode(), new Delete(idToDelete));
        options.put(Key.N.getKeyCode(), new ChangeScreen( ScreenType.SCREEN_LIST));
    }
    @Override
    public void proceed() {

        System.out.println("Please enter the record ID:");
        try{
            Scanner input = new Scanner(System.in);
            int inputInt = input.nextInt();
            idToDelete.set(inputInt);
            System.out.println("Are you sure to delete? [y/n]");
            readData();
        }
        catch(InputMismatchException e){
            ScreenOption option = new ChangeScreen( ScreenType.SCREEN_LIST);
            option.proceed();
        }
        catch(NoSuchElementException e){
            System.out.println("Record doesn't exist");
            proceed();
        }

    }
}
