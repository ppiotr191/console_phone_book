package com.phonebook.screens;

import com.phonebook.Person;
import com.phonebook.PhoneBook;
import com.phonebook.options.ChangeScreen;
import com.phonebook.options.ScreenOption;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScreenAddRecord extends Screen {

    private String[] labels = {"Name", "Surname", "Phone", "Address"};

    public boolean validate(String data){
        return !data.contains(";")&&!"".equals(data);
    }

    @Override
    public void proceed() {
        Person person = new Person();
        Scanner input = new Scanner(System.in);
        String inputData;
        Map<String, String> values = new HashMap<String, String>();
        for (String label : labels){
            do{
                System.out.println(String.format("Enter %s:", label));
                inputData = input.nextLine();
                if(validate(inputData)){
                    values.put(label, inputData);
                }
                else{
                    System.out.println("Incorrect data(dont use ; character)");
                }

            }while(!validate(inputData));

        }
        person.setName(values.get("Name"));
        person.setSurname(values.get("Surname"));
        person.setPhone(values.get("Phone"));
        person.setAddress(values.get("Address"));

        PhoneBook.getInstance().getPersons().add(person);
        try{
            PhoneBook.getInstance().saveToCsv();
        }
        catch(IOException e){
            System.out.println("Cannot save to database.");
        }

        ScreenOption screenOption = new ChangeScreen(ScreenType.SCREEN_LIST);
        screenOption.proceed();
    }
}
