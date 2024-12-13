package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\ntask 1");
        arrays();

        System.out.println("\ntask 2");
        primesGenerator(4);

        System.out.println("\ntask 3");
        setsAndComparators();

        System.out.println("\ntask 4");
        String text = "Fhe dqj FweF fweh qdiwq cjas fewiur dqd Fj dqwd fef wdw fth fef wekq snd fje qdiwq dQd fj Fwef fJ fjE QDIWQ";
        System.out.println("text = " + text);
        worsInText(text);

        System.out.println("\ntask 5");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "v");
        map.put(2, "v2");
        map.put(3, "v");
        map.put(4, "v4");
        System.out.println("origin: " + map);
        System.out.println("new: " + swapMap(map));
    }

    static void arrays() {
        int n = (int) ((Math.random() * 10) + 5);
        System.out.println("n = " + n);
        Integer[] array = new Integer[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 40);
        }

        System.out.println("a) original array: " + Arrays.toString(array));

        List<Integer> list = new ArrayList<>(List.of(array)); //new ArrayList<>(array.length);
        //List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        System.out.println("b) mass: " + list);

        Collections.sort(list);
        System.out.println("c) sort: " + list);

        Collections.reverse(list);
        System.out.println("d) revers: " + list);

        Collections.shuffle(list);
        System.out.println("e) shuffle: " + list);

        //list.addFirst(list.getLast());
        //list.removeLast();
        Collections.rotate(list, 1);
        System.out.println("f) step list: " + list);

        Set<Integer> unicList = new HashSet<>();
        List<Integer> duplicateList = new ArrayList<>();
        for (int number : list) {
            if (!unicList.add(number)) {
                duplicateList.add(number);
            }
        }
        System.out.println("g) unicList list: " + unicList);

        System.out.println("h) duplicate list: " + duplicateList);

        int[] newArray = list.stream().mapToInt(i -> i).toArray();
        System.out.println("i) new array: " + Arrays.toString(newArray));

        System.out.println("j)");
        for (int number : unicList) {
            System.out.println("number: " + number + " count: " + Collections.frequency(list, number));
        }
    }

    static void primesGenerator(int size) {
        PrimesGenerator pg = new PrimesGenerator();

        PrimesGeneratorTest pgt = new PrimesGeneratorTest(pg.generatList(size));
        pgt.showList();
        System.out.println("------");
        pgt.showReversList();
    }

    static void setsAndComparators() {
        Human human1 = new Human("name1", "qwert", 33);
        Human human2 = new Human("name2", "qwerty", 23);
        Human human3 = new Human("name3", "qwertyq", 23);
        Human human4 = new Human("name4", "qwertyqw", 21);
        Human human5 = new Human("name5", "qwertyq", 13);

        List<Human> humanList = List.of(human1, human2, human3, human4, human5);

        System.out.println("-----HashSet------");
        HashSet<Human> humanHashSet = new HashSet<>((humanList));
        for (Human h : humanHashSet) {
            System.out.println(h.name + " " + h.lastname + " " + h.age);
        }
        //порядок элементов вычисляется с помощью хэш кода, поэтому порядок элементов может меняться спустя какое то время

        System.out.println("-----LinkedHashSet------");
        LinkedHashSet<Human> humanLinkedHashSet = new LinkedHashSet<>((humanList));
        for (Human h : humanLinkedHashSet) {
            System.out.println(h.name + " " + h.lastname + " " + h.age);
        }
        //элементы отсортированы по порядку их добавления

        System.out.println("-----TreeSet------");
        TreeSet<Human> humanTreeSet = new TreeSet<>((humanList));
        for (Human h : humanTreeSet) {
            System.out.println(h.name + " " + h.lastname + " " + h.age);
        }
        //сортирует элементы в порядке позврастания, обеспечивая древовидную реализацию set'а
        //по умолчанию TreeSet использует сортировку по строке в лексикографическом порядке (сравнивает символы,
        //значит одинаковые слова пропадут т.к. set элементы не допускают повторения и их некуда положить

        System.out.println("-----TreeSet with comparator------");
        HumanComparatorByLastName humanComparator = new HumanComparatorByLastName();
        TreeSet<Human> comparatorTreeSet = new TreeSet<>(humanComparator);

        comparatorTreeSet.addAll((humanList));
        for (Human h : comparatorTreeSet) {
            System.out.println(h.name + " " + h.lastname + " " + h.age);
        }
        //Сортировка TreeSet задана с помощью компаратора, который сортирует элементы по длине фамилии
        //одинаковые по длине слова пропадают т.к. сортировка происходит по длине слов

        System.out.println("------TreeSet with double comparator-----");
        TreeSet<Human> humans = new TreeSet<>(Comparator.comparingInt(o -> o.age));

        humans.addAll((humanList));
        for (Human h : humans) {
            System.out.println(h.name + " " + h.lastname + " " + h.age);
        }
        //Массив отсортирован сначала по фамилии, потом по возрасту
        //элемент пропадет, если длина фамилии и возраст будут одинаковыми
    }

    static void worsInText(String text) {
        String[] textWords = text.toLowerCase().split(" ");

        Set<String> uniqWords = new HashSet<>(List.of(textWords));

        HashMap<String, Integer> wordsRepeat = new HashMap<>();
        for (String word : uniqWords) {
            wordsRepeat.put(word, Collections.frequency(List.of(textWords), word));
        }
        System.out.println(wordsRepeat);
    }

    static <K, V> Map<V, List<K>> swapMap(Map<K, V> originMap) {
        Map<V, List<K>> result = new HashMap<>();

        for (Map.Entry<K, V> entry : originMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            if (result.containsKey(value)) {
                result.get(value).add(key);
            } else {
                List<K> keys = new ArrayList<>();
                keys.add(key);
                result.put(value, keys);
            }
        }

        return result;
    }

}