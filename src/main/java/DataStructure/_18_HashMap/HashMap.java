package DataStructure._18_HashMap;

/**
 * In Java, HashMap is a part of Java’s collection since Java 1.2.
 * This class is found in java.util package. It provides the basic implementation of the Map interface
 * of Java. HashMap in Java stores the data in (Key, Value) pairs, and you can access them by an index
 * of another type (e.g. an Integer). One object is used as a key (index) to another object (value).
 * If you try to insert the duplicate key in HashMap, it will replace the element of the corresponding key.
 * <></>
 * Java HashMap is similar to HashTable, but it is unSynchronized.
 * It allows to store the null keys as well, but there should be only one null key object and
 * there can be any number of null values. This class makes no guarantees as to the order of the map.
 * To use this class and its methods, you need to import java.util.HashMap package or its superclass.
 * <></>
 * <></>
 * Keys and value can’t be primitive datatype. Key in Hashmap is valid if it implements hashCode()
 * and equals() method , it should also be immutable (immutable custom object )
 * so that hashcode and equality remains constant. Value in hashmap can be any wrapper class,
 * custom objects, arrays, any reference type or even null .
 * For example : Hashmap can have array as value but not as key.
 * <></>
 * <></>
 * Fast access time: HashMaps provide constant time access to elements, which means that retrieval
 * and insertion of elements are very fast, usually O(1) time complexity.
 * Uses hashing function: HashMaps uses a hash function to map keys to indices in an array.
 * This allows for a quick lookup of values based on keys.
 * Stores key-value pairs: Each element in a HashMap consists of a key-value pair. The key is used
 * to look up the associated value.
 * Supports null keys and values: HashMaps allow for null values and keys. This means that a null key
 * can be used to store a value, and a null value can be associated with a key.
 * Not ordered: HashMaps are not ordered, which means that the order in which elements
 * are added to the map is not preserved. However, LinkedHashMap is a variation of HashMap
 * that preserves the insertion order.
 * Allows duplicates: HashMaps allow for duplicate values, but not duplicate keys.
 * If a duplicate key is added, the previous value associated with the key is overwritten.
 * Thread-unsafe: HashMaps are not thread-safe, which means that if multiple threads access
 * the same hashmap simultaneously, it can lead to data inconsistencies.
 * If thread safety is required, ConcurrentHashMap can be used.
 * Capacity and load factor: HashMaps have a capacity, which is the number of elements that
 * it can hold, and a load factor, which is the measure of how full the hashmap can be before
 * it is resized.
 */

import java.util.LinkedList;


public class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int capacity;
    private int size;
    private LinkedList<Entry<K, V>>[] bucketsArray;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.bucketsArray = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            bucketsArray[i] = new LinkedList<>();
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getBucketArrayIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // put kay / value in HashMap
    public void put(K key, V value) {
        int index = getBucketArrayIndex(key);
        LinkedList<Entry<K, V>> bucket = bucketsArray[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;

        if ((double) size / capacity > LOAD_FACTOR) {
            // If load factor exceeds the threshold, rehash the map
            rehash();
        }
    }

    // get value by given key in HashMap
    public V get(K key) {
        int index = getBucketArrayIndex(key);
        LinkedList<Entry<K, V>> bucket = bucketsArray[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    // remove key / value in HashMap
    public void remove(K key) {
        int index = getBucketArrayIndex(key);
        LinkedList<Entry<K, V>> bucket = bucketsArray[index];
        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            bucket.remove(toRemove);
            size--;
        }
    }

    // contains value in HashMap by given key
    public boolean containsKey(K key) {
        int index = getBucketArrayIndex(key);
        LinkedList<Entry<K, V>> bucket = bucketsArray[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // size of HashMap
    public int size() {
        return size;
    }

    // isEmpty HashMap
    public boolean isEmpty() {
        return size == 0;
    }

    // print all element in HashMap
    public void printAll() {
        for (LinkedList<Entry<K, V>> bucket : bucketsArray) {
            for (Entry<K, V> entry : bucket) {
                System.out.println("Key: " + entry.key + ", Value: " + entry.value);
            }
        }
    }

    private void rehash() {
        int newCapacity = capacity * 2;
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new LinkedList<>();
        }

        for (LinkedList<Entry<K, V>> bucket : bucketsArray) {
            for (Entry<K, V> entry : bucket) {
                int newIndex = Math.abs(entry.key.hashCode()) % newCapacity;
                newBuckets[newIndex].add(entry);
            }
        }

        bucketsArray = newBuckets;
        capacity = newCapacity;
    }
}



