package DataStructure._18_HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(5, "five");
        hashMap.put(4, "four");
        hashMap.put(6, "six");
        hashMap.put(1, "one");
        hashMap.put(7, "seven");
        hashMap.put(2, "two");
        hashMap.put(8, "eight");

        System.out.println("All element in HashMap");
        hashMap.printAll();

        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Add value in HashMap");
        hashMap.put(11, "eleven");
        hashMap.printAll();

        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Get value by given key in HashMap");
        System.out.println(hashMap.get(1));

        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Remove from HashMap 11");
        hashMap.remove(11);
        hashMap.printAll();

        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Contains value in HashMap");
        System.out.println(hashMap.containsKey(8));

        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Size of HashMap");
        System.out.println(hashMap.size());

        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Is Empty HashMap");
        System.out.println(hashMap.isEmpty());

    }
}
