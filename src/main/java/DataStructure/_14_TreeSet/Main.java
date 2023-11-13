package DataStructure._14_TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(4);
        treeSet.add(1);
        treeSet.add(8);
        treeSet.add(3);
        treeSet.add(7);
        treeSet.add(4);
        treeSet.add(6);

        System.out.println("Print all element in TreeSet");
        treeSet.printAll();

        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Add 9 element in TreeSet");
        treeSet.add(9);
        treeSet.printAll();
        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Delete 1 element in TreeSet");
        System.out.println(treeSet.remove(1));
        treeSet.printAll();
        System.out.println();
        System.out.println("-------------------------------");

        System.out.println("Contains 3 number element in TreeSet");
        System.out.println(treeSet.contains(3));


    }
}
