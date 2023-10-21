package DataStructure._12_LinkedHashSet;

public class Main {

    public static void main(String[] args) {

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(1);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(6);

        System.out.println("Show all element in LinkedHashSet");
        linkedHashSet.printAllValues();

        System.out.println();
        System.out.println("Remove element in LinkedHashSet");
        System.out.println("Before remove 6");
        linkedHashSet.printAllValues();
        System.out.println();
        System.out.println("After remove 6");
        System.out.println(linkedHashSet.remove(6));
        linkedHashSet.printAllValues();

        System.out.println();
        System.out.println("LinkedHashSet contains 3");
        System.out.println(linkedHashSet.contains(3));

        System.out.println("Size of LinkedHashSet");
        System.out.println(linkedHashSet.size());

        System.out.println("Before clear all elements in LinkedHashSet");
        linkedHashSet.printAllValues();
        System.out.println();
        System.out.println("After clear all elements in LinkedHashSet");
        linkedHashSet.clearAllElement();
        System.out.println(linkedHashSet.size());





    }
}
