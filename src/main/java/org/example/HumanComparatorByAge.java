package org.example;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return Integer.compare(h1.age, h2.age);
    }
}
