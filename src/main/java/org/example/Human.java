package org.example;

public class Human implements Comparable<Human> {
    String name;
    String lastname;
    int age;

    public Human(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public int compareTo(Human h) {
        return Integer.compare(lastname.length(), h.lastname.length());
    }
}
