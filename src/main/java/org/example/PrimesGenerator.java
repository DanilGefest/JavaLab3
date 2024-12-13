package org.example;

import java.util.*;

public class PrimesGenerator {

    public List<Integer> generatList(int size) {
        List<Integer> list = new ArrayList<>();

        ListIterator<Integer> iterator = list.listIterator();
        while (list.size() < size) {
            iterator.add((int) (Math.random() * 100));
        }

        return list;
    }
}
