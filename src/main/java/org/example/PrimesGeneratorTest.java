package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PrimesGeneratorTest {
    private final List<Integer> list;

    PrimesGeneratorTest(List<Integer> setList) {
        list = setList;
    }

    public void showList() {
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void showReversList() {
        ListIterator iterator = list.listIterator(list.size());

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
