package DataStructure._12_LinkedHashSet;

/**
 * The LinkedHashSet is an ordered version of HashSet that maintains a
 * doubly linked List across all elements. When the iteration order is needed to be
 *  maintained, this class is used. When iterating through a HashSet, the order is
 *  unpredictable, while a LinkedHashSet lets us iterate through the elements in the
 *  order in which they were inserted. When cycling through LinkedHashSet
 *  using an iterator, the elements will be returned in the order in which they were inserted.
 */

public class LinkedHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private float loadFactor;
    private int size;
    private Entry<T>[] table;
    private Entry<T> first; // Head of the linked list

    private static class Entry<T> {
        T value;
        Entry<T> next;
        Entry<T> before, after;

        Entry(T value) {
            this.value = value;
        }
    }

    public LinkedHashSet() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public LinkedHashSet(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        this.table = new Entry[capacity];
        this.first = null;
    }


    // add value to LinkedHashSet
    public boolean add(T value) {
        int index = hash(value);
        if (contains(value))
            return false;

        Entry<T> entry = new Entry<>(value);
        entry.next = table[index];
        table[index] = entry;
        linkEntryLast(entry);

        size++;

        if ((float) size / capacity >= loadFactor)
            resize();

        return true;
    }

    // remove value from LinkedHashSet
    public boolean remove(T value) {
        int index = hash(value);
        Entry<T> previous = null;
        Entry<T> current = table[index];

        while (current != null) {
            if (current.value.equals(value)) {
                if (previous == null)
                    table[index] = current.next;
                else
                    previous.next = current.next;
                unlinkEntry(current);
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    // contains value on LinkedHashSet
    public boolean contains(T value) {
        int index = hash(value);
        Entry<T> current = table[index];

        while (current != null) {
            if (current.value.equals(value))
                return true;
            current = current.next;
        }

        return false;
    }

    // clear all elements in LinkedHashSet
    public void clearAllElement() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
        first = null;
    }

    // size of LinkedHashSet
    public int size() {
        return size;
    }

    // print all values in LinkedHashSet
    public void printAllValues() {
        Entry<T> current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.after;
        }
    }




    /**
     * linkEntryLast method is used to insert an entry at the end of the linked list,
     * preserving the order of insertion, which is a characteristic of a LinkedHashSet.
     */
    private void linkEntryLast(Entry<T> entry) {
        if (first == null) {
            first = entry;
            return;
        }

        Entry<T> last = first;
        while (last.after != null) {
            last = last.after;
        }

        last.after = entry;
        entry.before = last;
    }

    /**
     *  The unlinkEntry method ensures that the entry being removed is correctly unlinked
     *  from the linked list, and the adjacent entries are updated to maintain
     *  the list's integrity and order. This is a crucial operation when removing elements
     *  from a LinkedHashSet to ensure that the linked list remains consistent and
     *  elements are removed properly.
     */
    private void unlinkEntry(Entry<T> entry) {
        Entry<T> before = entry.before;
        Entry<T> after = entry.after;

        if (before == null) {
            first = after;
        } else {
            before.after = after;
        }

        if (after != null) {
            after.before = before;
        }
    }

    private void resize() {
        capacity *= 2;
        Entry<T>[] newTable = new Entry[capacity];

        for (int i = 0; i < table.length; i++) {
            Entry<T> entry = table[i];
            while (entry != null) {
                Entry<T> next = entry.next;
                int newIndex = hash(entry.value);
                entry.next = newTable[newIndex];
                newTable[newIndex] = entry;
                entry = next;
            }
        }

        table = newTable;
    }

    /**
     * & 0x7FFFFFFF: The & operator is a bitwise AND operation.
     * The 0x7FFFFFFF is a hexadecimal representation of a positive integer
     * with the sign bit (the leftmost bit) set to 0.
     * This operation effectively clears the sign bit from the hash code,
     * ensuring that the result is always a positive integer or zero.
     */
    private int hash(T value) {
        return (value == null) ? 0 : (value.hashCode() & 0x7FFFFFFF) % capacity;
    }

}

