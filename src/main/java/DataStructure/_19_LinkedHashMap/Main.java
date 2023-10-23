package DataStructure._19_LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // element is maintains insertion order
        linkedHashMap.put(4, "four");
        linkedHashMap.put(3, "three");
        linkedHashMap.put(6, "six");
        linkedHashMap.put(2, "two");
        linkedHashMap.put(5, "five");
        linkedHashMap.put(9, "nine");
        linkedHashMap.put(1, "one");

        System.out.println("See all element in LinkedHasMap");
        linkedHashMap.printAllElements();

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Put element 11");
        linkedHashMap.put(11, "eleven");
        linkedHashMap.printAllElements();

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Remove 9");
        linkedHashMap.remove(9);
        linkedHashMap.printAllElements();

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Get element on key 5");
        System.out.println(linkedHashMap.get(5));

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Is empty LinkedHashSet");
        System.out.println(linkedHashMap.isEmpty());

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Size of LinkedHashSet");
        System.out.println(linkedHashMap.size());

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Before clear all element in LinkedHashSet");
        linkedHashMap.printAllElements();

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("After clear all element in LinkedHashMap");
        linkedHashMap.clear();
        System.out.println("LinkedHashMap is empty: ");
        System.out.println(linkedHashMap.isEmpty());
        linkedHashMap.printAllElements();



    }
}
