package com.phonebook;

public class Person {

    private static int counter;
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String address;

    private Person(PersonBuilder personBuilder){
        id = ++counter;
        name = personBuilder.name;
        surname = personBuilder.surname;
        phone = personBuilder.phone;
        address = personBuilder.address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static class PersonBuilder{
        private String name;
        private String surname;
        private String phone;
        private String address;

        public PersonBuilder(String name, String surname){
            this.name = name;
            this.surname = surname;
        }

        public PersonBuilder phone(String phone){
            this.phone = phone;
            return this;
        }

        public PersonBuilder address(String address){
            this.address = address;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
