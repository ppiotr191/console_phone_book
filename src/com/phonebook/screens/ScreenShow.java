package com.phonebook.screens;

import com.phonebook.Person;
import com.phonebook.PhoneBook;
import com.phonebook.options.ChangeScreen;
import com.phonebook.options.NextPerson;
import com.phonebook.options.PreviousPerson;
import com.phonebook.options.ScreenOption;
import com.phonebook.utils.Key;

import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ScreenShow extends Screen {

    protected AtomicInteger idToShow;
    Person person;
    ListIterator<Person> iterator;
    boolean directionRight;
    boolean isEnterID = true;

    public boolean isDirectionRight() {
        return directionRight;
    }

    public void setDirectionRight(boolean directionRight) {
        this.directionRight = directionRight;
    }

    public ScreenShow() {
        idToShow = new AtomicInteger(0);
        options.put(Key.N.getKeyCode(), new NextPerson(this));
        options.put(Key.P.getKeyCode(), new PreviousPerson(this));
        options.put(Key.E.getKeyCode(), new ChangeScreen( ScreenType.SCREEN_LIST));
    }

    public void showPerson(Person person){
        System.out.println("Person:");
        System.out.println("Id:" + person.getId());
        System.out.println("Name:" + person.getName());
        System.out.println("Surname:" + person.getSurname());
        System.out.println("Address:" + person.getAddress());
    }

    @Override
    void showMenu(){
        PhoneBook phoneBook = PhoneBook.getInstance();
        String paginateOption = "";
        int size = phoneBook.getPersons().size();

        int pages = size;
        if (iterator.hasPrevious()){
            paginateOption += "[P]revious  ";
        }
        if (iterator.hasNext()){
            paginateOption += "[N]ext  ";
        }

        System.out.println( paginateOption + "[E]xit" );
    }

    @Override
    public void proceed() {
        try{
            System.out.println(idToShow.get());
            if (isEnterID){
                System.out.println("Please enter the record ID:");
                Scanner input = new Scanner(System.in);
                int inputInt = input.nextInt();
                idToShow.set(inputInt);
                person = PhoneBook.getInstance().getPersons().stream().filter(p -> p.getId().intValue() == idToShow.get()).findFirst().get();
                if (person == null){
                    throw new NoSuchElementException();
                }
                int index = PhoneBook.getInstance().getPersons().indexOf(person);
                iterator = PhoneBook.getInstance().getPersons().listIterator(index);
                isEnterID = false;
            }
            showPerson(person);
            System.out.println();
            showMenu();
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

    public ListIterator<Person> getIterator() {
        return iterator;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
