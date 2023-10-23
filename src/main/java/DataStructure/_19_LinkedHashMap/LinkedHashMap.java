package DataStructure._19_LinkedHashMap;

/**
 * The LinkedHashMap Class is just like HashMap with an additional feature of maintaining an order
 * of elements inserted into it. HashMap provided the advantage of quick insertion, search,
 * and deletion, but it never maintained the track and order of insertion,
 * which the LinkedHashMap provides where the elements can be accessed in their insertion order.
 * Important Features of a LinkedHashMap are listed as follows:
 * A LinkedHashMap contains values based on the key.
 * It implements the Map interface and extends the HashMap class.
 * It contains only unique elements.
 * !!!!!! It may have one null key and multiple null values. !!!!!!!
 * It is non-synchronized.
 * It is the same as HashMap with an additional feature that it maintains insertion order.
 * For example, when we run the code with a HashMap, we get a different order of elements.
 * public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkedHashMap<K, V> {

    private Map<K, V> map;
    private LinkedList<K> keyList;

    public LinkedHashMap() {
        map = new HashMap<>();
        keyList = new LinkedList<>();
    }



    public void put(K key, V value) {
        if (map.containsKey(key)) {
            keyList.remove(key); // Remove the key from its current position
        }
        keyList.add(key);        // Add the key to the end of the list
        map.put(key, value);
    }

    public void remove(K key) {
        if (map.containsKey(key)) {
            keyList.remove(key); // Remove the key from the list
            map.remove(key);
        }
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
        keyList.clear();
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            keyList.remove(key); // Remove the key from its current position
            keyList.add(key);    // Add the key to the end of the list
            return map.get(key);
        }
        return null;
    }

    public int size() {
        return map.size();
    }

    public void printAllElements() {
        for (K key : keyList) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    @Override
    public String toString() {
        return keyList.toString();
    }
}
