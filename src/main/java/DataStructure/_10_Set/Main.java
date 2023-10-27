package DataStructure._10_Set;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new Set<>();

        set.add(1);
        set.add(1);
        set.add(3);
        set.add(4);
        set.add(2);
        set.add(5);

        System.out.println("See all element in Set");
        set.display();

        System.out.println("Set contains element");
        System.out.println(set.contains(1));

        System.out.println("Set remove element");
        System.out.println(set.remove(1));
        set.display();

        System.out.println("Set size");
        set.display();
        System.out.println(set.size());

        System.out.println("Set get first element");
        set.display();
        System.out.println(set.getFirstElement());

        System.out.println("Set get rear element");
        set.display();
        System.out.println(set.getLastElement());

        System.out.println("Set get value of the index");
        set.display();
        System.out.println(set.getValueAtIndex(1));

        System.out.println("Before Sort Set");
        set.display();
        set.sortAlphabetically();
        System.out.println("After Sort Set");
        set.display();

        System.out.println("Before Reverse Set");
        set.display();
        set.reverse();
        System.out.println("After Reverse Set");
        set.display();



    }
}
