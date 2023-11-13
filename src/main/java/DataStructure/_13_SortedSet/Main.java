package DataStructure._13_SortedSet;

public class Main {

    public static void main(String[] args) {

        SortedSet<Integer> sortedSet = new SortedSet<>();

        sortedSet.add(7);
        sortedSet.add(3);
        sortedSet.add(5);
        sortedSet.add(1);
        sortedSet.add(0);
        sortedSet.add(4);

        System.out.println("All element in SortedSet");
        sortedSet.printInOrder();

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("Before remove");
        sortedSet.printInOrder();
        System.out.println();
        System.out.println("After remove");
        System.out.println(sortedSet.remove(0));
        sortedSet.printInOrder();

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("Size of SortedSet is:");
        System.out.println(sortedSet.size());

        System.out.println();
        System.out.println("--------------------------------");
        SortedSet<String> stringSet = new SortedSet<>();
        stringSet.add("date");
        stringSet.add("cherry");
        stringSet.add("banana");
        stringSet.add("fig");
        stringSet.add("apple");

        System.out.println();
        stringSet.printInOrder();




    }
}
