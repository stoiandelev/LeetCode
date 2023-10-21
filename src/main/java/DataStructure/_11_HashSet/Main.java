package DataStructure._11_HashSet;

public class Main {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();

        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);

        System.out.println("Print all values in HashSet");
        hashSet.printAllValues();
        System.out.println();
        System.out.println("--------------------------------");

        System.out.println("Add element in HashSet");
        hashSet.add(6);
        hashSet.printAllValues();
        System.out.println();
        System.out.println("--------------------------------");


        System.out.println("Remove element in HashSet");
        System.out.println("Before remove");
        hashSet.printAllValues();
        hashSet.remove(1);
        System.out.println();
        System.out.println("After remove");
        hashSet.printAllValues();
        System.out.println();
        System.out.println("--------------------------------");



        System.out.println("Contains element in HashSet");
        System.out.println(hashSet.contains(4));
        System.out.println();
        System.out.println("--------------------------------");

        System.out.println("Size of HashSet");
        System.out.println(hashSet.size());
        System.out.println();
        System.out.println("--------------------------------");

        System.out.println("HashSet is empty?");
        System.out.println(hashSet.isEmpty());
        System.out.println();
        System.out.println("--------------------------------");

        System.out.println("Reverse HashSet");
        System.out.println("Before Reverse HashSet");
        hashSet.printAllValues();
        hashSet.reverse();
        System.out.println();
        System.out.println("After Reverse HashSet");
        hashSet.printAllValues();
        System.out.println();
        System.out.println("--------------------------------");



        System.out.println("Clear all element in HashSet");
        System.out.println("Before clear method");
        hashSet.printAllValues();
        System.out.println();
        System.out.println("After clear method");
        hashSet.clearAllElement();
        hashSet.printAllValues();

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("HashSet is empty?");
        System.out.println(hashSet.isEmpty());






    }
}
