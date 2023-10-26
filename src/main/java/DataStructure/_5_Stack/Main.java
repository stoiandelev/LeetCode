package DataStructure._5_Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("All element in Stack");
        stack.printAll();

        System.out.println("Remove element");
        stack.pop();
        stack.printAll();

        System.out.println("Peek top element on stack");
        System.out.println(stack.peek());

        System.out.println("Size on stack");
        System.out.println(stack.size());

        System.out.println("Check Stack is empty");
        System.out.println(stack.isEmpty());


    }
}
