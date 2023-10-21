package DataStructure._11_HashSet;

/**
 * Java HashSet class implements the Set interface, backed by a hash table,
 * which is actually a HashMap instance. No guarantee is made as to the iteration
 * order of the hash sets, which means that the class does not guarantee the
 * constant order of elements over time.
 * This class permits the null element. The class also offers constant time
 * performance for the basic operations like add, remove, contains,
 * and size assuming the hash function disperses the elements properly
 * among the buckets, which we shall see further in the article.
 * <></>
 * Java HashSet Features
 * A few important features of HashSet are mentioned below:
 * <></>
 * Implement Set Interface.
 * The underlying data structure for HashSet is Hashtable.
 * As it implements the Set Interface, duplicate values are not allowed.
 * Objects that you insert in HashSet are not guaranteed to be inserted in the same order. Objects are inserted based on their hash code.
 * NULL elements are allowed in HashSet.
 * HashSet also implements Serializable and Cloneable interfaces.
 */

public class HashSet {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int capacity;
    private int size;
    private Entry[] table;

    private static class Entry {
        int key;
        Entry next;

        Entry(int key) {
            this.key = key;
        }
    }

    public HashSet() {
        this(DEFAULT_CAPACITY);
    }

    public HashSet(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Entry[capacity];
    }

    private int hash(int key) {
        int result = key % capacity;
        return result;
    }

    private void resize() {
        capacity *= 2;
        size = 0;
        Entry[] newTable = new Entry[capacity];

        for (Entry oldEntry : table) {
            Entry current = oldEntry;

            while (current != null) {
                Entry next = current.next;
                current.next = null;
                int index = hash(current.key);
                if (newTable[index] == null) {
                    newTable[index] = current;
                } else {
                    Entry newCurrent = newTable[index];
                    while (newCurrent.next != null) {
                        newCurrent = newCurrent.next;
                    }
                    newCurrent.next = current;
                }
                size++;
                current = next;
            }
        }

        table = newTable;
    }


    // add element in HashSet
    public void add(int key) {
        int index = hash(key);
        Entry entry = new Entry(key);
        if (table[index] == null) {
            table[index] = entry;
        } else {
            Entry current = table[index];
            Entry previous = null;
            while (current != null) {
                if (current.key == key) {
                    return; // Key already exists, no duplicates allowed
                }
                previous = current;
                current = current.next;
            }
            previous.next = entry;
        }
        size++;

        // Resize if the load factor exceeds a threshold
        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
    }

    // remove element in HashSet
    public void remove(int key) {
        int index = hash(key);
        Entry current = table[index];
        Entry previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    // contains element in HashSet
    public boolean contains(int key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // size of HashSet
    public int size() {
        return size;
    }

    // is Empty HashSet
    public boolean isEmpty() {
        return size == 0;
    }

    // clear all elements in HashSet
    public void clearAllElement() {
        capacity = DEFAULT_CAPACITY; // Reset the capacity to its default value
        size = 0; // Reset the size to 0
        table = new Entry[capacity]; // Create a new array of entries
    }

    // print all values in HashSet
    public void printAllValues() {
        for (Entry entry : table) {
            Entry current = entry;
            while (current != null) {
                System.out.print(current.key + " ");
                current = current.next;
            }
        }
    }

    // reverse the elements in HashSet
    public void reverse() {
        Entry[] newTable = new Entry[capacity];
        Entry[] tempTable = table;

        // Reverse the order of buckets in the table
        for (int i = 0; i < capacity; i++) {
            Entry current = table[i];
            Entry previous = null;
            Entry next;

            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            newTable[capacity - 1 - i] = previous; // Update the head of the reversed list
        }

        table = newTable;

    }


}


