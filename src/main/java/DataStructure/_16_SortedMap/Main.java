package DataStructure._16_SortedMap;

public class Main {

    public static void main(String[] args) {

        SortedMap<Integer, String> sortedMap = new SortedMap<>();

        sortedMap.put(8, "eight");
        sortedMap.put(3, "three");
        sortedMap.put(6, "six");
        sortedMap.put(9, "nine");
        sortedMap.put(2, "two");
        sortedMap.put(1, "one");

        System.out.println("Print all key values in SortedMap");
        sortedMap.printAll();

        System.out.println();
        System.out.println("---------------------------");

        System.out.println("Put value in key 1 in SortedMap");
        sortedMap.put(1, "newValueOnOne");
        sortedMap.printAll();

        System.out.println();
        System.out.println("---------------------------");

        System.out.println("Get value in key 2 in SortedMap");
        System.out.println(sortedMap.get(2));

        System.out.println();
        System.out.println("---------------------------");

        System.out.println("Remove 2 in SortedMap");
        sortedMap.remove(2);
        sortedMap.printAll();

        System.out.println();
        System.out.println("---------------------------");

        System.out.println("Contains 2 in SortedMap");
        System.out.println(sortedMap.containsKey(2));

        System.out.println();
        System.out.println("---------------------------");

        System.out.println("Size of SortedMap");
        System.out.println(sortedMap.size());

        System.out.println();
        System.out.println("---------------------------");

        System.out.println("Is empty SortedMap");
        System.out.println(sortedMap.isEmpty());



    }
}
