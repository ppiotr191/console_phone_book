package com.phonebook.screens;

import com.phonebook.Person;
import com.phonebook.PhoneBook;
import com.phonebook.utils.Utils;
import com.phonebook.options.ChangeScreen;
import com.phonebook.options.Next;
import com.phonebook.options.Previous;

import java.util.List;

public class ScreenList extends Screen {

    private final int PAGINATION = 10;
    private int currentPage;

    public ScreenList() {
        currentPage = 0;
        options.put(110, new Next(this));
        options.put(112, new Previous(this));
        options.put(101, new ChangeScreen(ScreenType.SCREEN_EXIT));
        options.put(97, new ChangeScreen(ScreenType.SCREEN_ADD_RECORD));
        options.put(99, new ChangeScreen(ScreenType.SCREEN_CLEAR_ALL));
        options.put(100, new ChangeScreen(ScreenType.SCREEN_DELETE));
    }

    public void incrementCurrentPage(int inc){
        currentPage += inc;
    }

    @Override
    void showMenu(){
        PhoneBook phoneBook = PhoneBook.getInstance();
        String paginateOption = "";
        int size = phoneBook.getPersons().size();
        int pages = size/PAGINATION;
        if (currentPage > 0){
            paginateOption += "[P]revious  ";
        }
        if (currentPage < pages - 1){
            paginateOption += "[N]ext  ";
        }

        System.out.println( paginateOption + "[A]dd record  [D]elete  [C]lear all  [E]xit" );
    }

    @Override
    public void proceed() {
        PhoneBook phoneBook = PhoneBook.getInstance();
        System.out.flush();
        System.out.println("Phoneboook 1.0v");
        System.out.println(currentPage);

        List<Person> persons = Utils.getPage(phoneBook.getPersons(),currentPage + 1, PAGINATION);

        if (phoneBook.getPersons().isEmpty()){
            System.out.println("(no data)");
        }
        else{
            String format = "%-6s%-22s%-32s%-32s%-32s\n";
            System.out.format(format,"ID:","Name:", "Surname:", "Phone:", "Address:" );
            for(Person person : persons){
                System.out.format(format,person.getId(), person.getName(), person.getSurname(), person.getPhone(),person.getAddress() );
            }
        }
        System.out.println();
        showMenu();
        readData();
    }
}
