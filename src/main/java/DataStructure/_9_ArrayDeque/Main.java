package DataStructure._9_ArrayDeque;

public class Main {

    public static void main(String[] args) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        arrayDeque.addFirst("Element 10");
        arrayDeque.addFirst("Element 9");
        arrayDeque.addFirst("Element 7");
        arrayDeque.addLast("Element 2");
        arrayDeque.addLast("Element 1");
        arrayDeque.addFirst("Element 11");

        System.out.println("All element in ArrayDeque: ");
        arrayDeque.display();

        System.out.println("Add element of begin at ArrayDeque");
        arrayDeque.addFirst("Element 33");
        arrayDeque.display();

        System.out.println("Add element of rear at ArrayDeque");
        arrayDeque.addLast("Element 44");
        arrayDeque.display();

        System.out.println("Remove first element of ArrayDeque");
        arrayDeque.removeFirst();
        arrayDeque.display();

        System.out.println("Remove rear element of ArrayDeque");
        arrayDeque.removeLast();
        arrayDeque.display();

        System.out.println("See first element of ArrayDeque");
        System.out.println(arrayDeque.peekFirst());
        arrayDeque.display();

        System.out.println("See rear element of ArrayDeque");
        System.out.println(arrayDeque.peekLast());
        arrayDeque.display();

        System.out.println("See ArrayDeque is empty");
        System.out.println(arrayDeque.isEmpty());

        System.out.println("See ArrayDeque size");
        arrayDeque.display();
        System.out.println(arrayDeque.size());



    }
}
