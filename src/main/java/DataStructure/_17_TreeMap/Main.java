package DataStructure._17_TreeMap;

public class Main {

    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(7, "seven");
        treeMap.put(4, "four");
        treeMap.put(2, "two");
        treeMap.put(6, "six");
        treeMap.put(1, "one");
        treeMap.put(3, "three");
        treeMap.put(9, "nine");

        System.out.println("Print all element in _17_TreeMap");
        treeMap.printAll();

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Put element 5 in _17_TreeMap");
        treeMap.put(5, "five");
        treeMap.printAll();

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Get element 1 in _17_TreeMap");
        System.out.println(treeMap.get(1));

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Remove element 1 in _17_TreeMap");
        treeMap.remove(1);
        treeMap.printAll();

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Size of _17_TreeMap");
        System.out.println(treeMap.size());

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Is Empty _17_TreeMap");
        System.out.println(treeMap.isEmpty());



    }
}
