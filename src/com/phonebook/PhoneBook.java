package com.phonebook;

import com.phonebook.screens.Screen;
import com.phonebook.screens.ScreenList;
import com.phonebook.utils.CSVUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private final String csvFile = "database.csv";
    private static PhoneBook instance;

    private List<Person> persons;
    private Screen screen;

    private PhoneBook(){
        persons = new ArrayList<Person>();
        try{
            loadFromCsv();
        }
        catch (FileNotFoundException e) {
            System.out.println("Database file not found");
        }

        screen = new ScreenList();
    }

    public static PhoneBook getInstance(){
        if(instance == null){
            instance = new PhoneBook();
        }
        return instance;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void run(){
        screen.proceed();
    }

    public void loadFromCsv() throws FileNotFoundException{

            Scanner scanner = new Scanner(new File(csvFile));
            while (scanner.hasNext()) {
                List<String> line = CSVUtils.parseLine(scanner.nextLine());
                Person person = new Person();
                person.setName(line.get(0));
                person.setSurname(line.get(1));
                person.setPhone(line.get(2));
                person.setAddress(line.get(3));
                persons.add(person);
            }
            scanner.close();
    }

    public void saveToCsv() throws IOException{
        FileWriter writer = new FileWriter(csvFile);

        for (Person d : persons) {

            List<String> list = new ArrayList<>();
            list.add(d.getName());
            list.add(d.getSurname());
            list.add(d.getPhone());
            list.add(d.getAddress());

            CSVUtils.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }
}
