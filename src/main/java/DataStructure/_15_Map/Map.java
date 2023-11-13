package DataStructure._15_Map;

/**
 * Map data structure (also known as a dictionary, associative array, or hash map)
 * is defined as a data structure that stores a collection of key-value pairs,
 * where each key is associated with a single value.
 * Maps provide an efficient way to store and retrieve data based on a unique identifier (the key).
 * <></>
 * Uniqueness: The keys in a map are unique, meaning that each key can only map to one value.
 * Mutability: Maps are mutable, meaning that their elements can be changed after they are created.
 * Associativity: Maps associate keys with values, meaning that each key is associated with exactly one value.
 * Ordering: Maps do not have an inherent ordering, meaning that the order in which elements are
 * inserted into a map does not affect the order in which they are retrieved.
 * Hashing: Maps are typically implemented using hash tables,
 * meaning that keys are hashed to indices in an underlying array, and values
 * are stored in the corresponding array elements.
 * Hashing in Java is a technique for mapping data to a secret key,
 * which can be used as a unique identifier for data.
 * this function is known as the Hash-function, and the output of this function (keys) is known as Hash-values.
 * Complexity: The time complexity for basic operations on a map, such as insert, lookup, and delete,
 * is usually O(1) on average, meaning that these operations take a constant amount of time,
 * on average, regardless of the size of the map.
 * However, the worst-case time complexity can be O(n),
 * where n is the number of elements in the map, in the case of hash collisions.
 */

/**
 * Hashmap vs Hashtable
 * HashMap is non-synchronized.
 * It is not thread-safe and can't be shared between many threads
 * without proper synchronization code
 * whereas Hashtable is synchronized.
 * it is thread-safe and can be shared with many threads.
 */

import java.util.ArrayList;
import java.util.List;

public class Map<K, V> {

    private List<Entry<K, V>> entries;

    public Map() {
        entries = new ArrayList<>();
    }

    // Custom Entry class to hold key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Put a key-value pair into the map
    public void put(K key, V value) {
        // Check if the key already exists and update its value
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // If the key doesn't exist, add a new entry
        entries.add(new Entry<>(key, value));
    }

    // Get the value associated with a key
    public V get(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove a key-value pair from the map
    public void remove(K key) {
        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            entries.remove(toRemove);
        }
    }

    // Check if the map contains a specific key
    public boolean containsKey(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Get the number of key-value pairs in the map
    public int size() {
        return entries.size();
    }

    // Print all key-value pairs in the map
    public void printAll() {
        for (Entry<K, V> entry : entries) {
            System.out.println("Key: " + entry.key + ", Value: " + entry.value);
        }
    }

    // Check if the map is empty
    public boolean isEmpty() {
        return entries.isEmpty();
    }
}




