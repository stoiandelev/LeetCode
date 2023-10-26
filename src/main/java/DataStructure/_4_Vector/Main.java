package DataStructure._4_Vector;

public class Main {

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);

        System.out.println("Print all element");
        vector.printAll();

        System.out.println("Add element");
        vector.add(7);
        vector.printAll();

        System.out.println("Get element");
        System.out.println(vector.get(0));

        System.out.println("Get size of Vector");
        System.out.println(vector.size());

        System.out.println("Boolean Vector is empty");
        System.out.println(vector.isEmpty());

        System.out.println("Remove element");
        vector.remove(0);
        vector.printAll();

        System.out.println("Vector contains element");
        System.out.println(vector.contains(2));

        System.out.println("Reverse Vector");
        vector.reverse();
        vector.printAll();

        System.out.println("Reverse between two index");
        vector.printAll();
        vector.reverseBetweenIndices(1, 2);
        vector.printAll();


    }
}
