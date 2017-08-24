package com.phonebook.screens;

import com.phonebook.options.ScreenOption;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Screen {

    protected Map<Integer, ScreenOption> options;

    public Screen(){
        options = new HashMap<Integer, ScreenOption>();
    }

    public void readData(){
        int choose;
        Scanner input = new Scanner(System.in);
        choose = input.next().toLowerCase().charAt(0);

        ScreenOption option = options.get(choose);
        if (option != null){
            option.proceed();
            return;
        }
        System.out.println("Please choose another option");
        proceed();
    }

    void showMenu(){
        String format = "%-8s%-14s%-10s%-10s\n";
        System.out.format(format, "[N]ext", "[A]dd record", "[D]elete", "[C]lear all","[E]xit" );
    }

    abstract public void proceed();

}
