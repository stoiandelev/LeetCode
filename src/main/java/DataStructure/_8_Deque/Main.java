package DataStructure._8_Deque;

public class Main {

    public static void main(String[] args) {

        Deque<String> deque = new Deque<>();

        deque.addFront("Element 1");
        deque.addRear("Element 2");
        deque.addFront("Element 3");

        System.out.println("Show all element in Deque");
        deque.display();

        System.out.println("Add element of front of Deque");
        deque.addFront("Element 11");
        deque.display();

        System.out.println("Add element of rear of Deque");
        deque.addRear("Element 21");
        deque.display();

        System.out.println("Remove front element");
        System.out.println(deque.removeFront());
        deque.display();

        System.out.println("Remove rear element");
        System.out.println(deque.removeRear());
        deque.display();

        System.out.println("See front element");
        System.out.println(deque.peekFront());

        System.out.println("See rear element");
        System.out.println(deque.peekRear());

        System.out.println("See Deque is empty");
        System.out.println(deque.isEmpty());

        System.out.println("See Deque size");
        System.out.println(deque.size());



    }
}
