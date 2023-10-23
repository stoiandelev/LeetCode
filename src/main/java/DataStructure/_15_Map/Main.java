package DataStructure._15_Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> map = new Map<>();

        map.put(1, "one");
        map.put(2, "one");
        map.put(3, "one");
        map.put(4, "one");
        map.put(5, "one");
        map.put(6, "one");

        System.out.println("See all values in map");
        map.printAll();

        System.out.println();
        System.out.println("----------------------");

        System.out.println("Put value in map");
        map.put(1, "newValueOne");
        map.printAll();

        System.out.println();
        System.out.println("----------------------");

        System.out.println("Get value in determined key");
        System.out.println( map.get(1));

        System.out.println();
        System.out.println("----------------------");

        System.out.println("Remove key 1");
        map.remove(1);
        map.printAll();

        System.out.println();
        System.out.println("----------------------");

        System.out.println("Check if the map contains a specific key");
        System.out.println(map.containsKey(1));

        System.out.println();
        System.out.println("----------------------");

        System.out.println("Check of the map");
        System.out.println(map.size());

        System.out.println();
        System.out.println("----------------------");

        System.out.println("Check of the map is empty");
        System.out.println(map.isEmpty());






    }

}
