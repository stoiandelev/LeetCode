package DataStructure._6_Queue;

public class Main {

    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();

        queue.enqueue("Element 1");
        queue.enqueue("Element 2");
        queue.enqueue("Element 3");

        queue.display();

        System.out.println("Remove element");
        queue.dequeue();
        queue.display();

        System.out.println("Queue is empty");
        System.out.println(queue.isEmpty());

        System.out.println("Queue size");
        System.out.println(queue.size());

        System.out.println("Show top element, without delete");
        System.out.println(queue.peekShowTopElement());

        System.out.println("Add an element to the top (front) of the queue");
        queue.addFirst("Element 10");
        queue.display();

        System.out.println("Add an element to the /end/ of the queue");
        queue.enqueue("Element 89");
        queue.display();



    }
}
