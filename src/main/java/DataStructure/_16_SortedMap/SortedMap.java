package DataStructure._16_SortedMap;

/**
 * SortedMap is an interface in the collection framework. This interface extends the
 * Map interface and provides a total ordering of its elements
 * (elements can be traversed in sorted order of keys).
 * The class that implements this interface is _17_TreeMap.
 * The SortedMap interface is a subInterface of the java.util.Map interface in Java.
 * It extends the Map interface to provide a total ordering of its elements,
 * based on the natural order of its keys.
 * The main difference between a SortedMap and a regular Map is that the elements
 * in a SortedMap are stored in a sorted order, whereas in a Map the elements
 * are stored in an arbitrary order. The sorting order is determined by the
 * natural order of the keys, which must implement the java.lang.
 * Comparable interface, or by a Comparator passed to the SortedMap’s constructor.
 * null key not permitted.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class SortedMap<K extends Comparable<K>, V> {

    private List<K> keys;
    private TreeMap<K, V> values;

    public SortedMap() {
        keys = new ArrayList<>();
        values = new TreeMap<>();
    }

    // put key value in SortedMap
    public void put(K key, V value) {
        if (!keys.contains(key)) {
            keys.add(key);
            keys.sort(null);
        }
        values.put(key, value);
    }

    // get value in SortedMap
    public V get(K key) {
        return values.get(key);
    }

    // remove key in SortedMap
    public void remove(K key) {
        if (keys.contains(key)) {
            keys.remove(key);
            values.remove(key);
        }
    }

    // contains key in SortedMap
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    // size in SortedMap
    public int size() {
        return keys.size();
    }

    // is empty SortedMap
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    public void printAll() {
        for (K key : keys) {
            System.out.println("Key: " + key + ", Value: " + values.get(key));
        }
    }


}



