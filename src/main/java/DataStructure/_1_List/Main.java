package DataStructure._1_List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new List<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Print all element");
        list.printAll();

        System.out.println("_1_List add element");
        list.add(6);
        list.printAll();

        System.out.println("_1_List get element");
        System.out.println(list.get(0));

        System.out.println("Size of list");
        System.out.println(list.size());

        System.out.println("Boolean list is empty");
        System.out.println(list.isEmpty());

        System.out.println("Remove element");
        list.remove(0);
        list.printAll();

        System.out.println("Contains element");
        System.out.println(list.contains(3));

        System.out.println("Before reverse the List");
        list.printAll();
        System.out.println("After reverse the List");
        list.reverse();
        list.printAll();

        System.out.println("Reverse between two index in the List");
        System.out.println("Original list");
        list.printAll();
        list.reverseBetweenIndices(1, 3);
        System.out.println("Between two index list");
        list.printAll();




    }
}
