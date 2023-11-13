package DataStructure._7_PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.enqueue(5);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(1);
        priorityQueue.enqueue(4);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(6);

        System.out.println("All element in Priority Queue");
        priorityQueue.display();

        System.out.println("Highest priority element in Priority Queue");
        System.out.println(priorityQueue.peekHighestPriorityWithoutDelete());

        System.out.println("Delete element in Priority Queue");
        System.out.println(priorityQueue.dequeue());
        priorityQueue.display();

        System.out.println("Check if Priority Queue is empty");
        System.out.println(priorityQueue.isEmpty());

        System.out.println("Check if Priority Queue size");
        System.out.println(priorityQueue.size());


    }
}
