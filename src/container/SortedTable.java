package container;

/**
 * An interface of table that provides ordering the keys in ascending order.
 *
 */

public interface SortedTable <K extends Comparable<K>, V> extends Table<K, V> {

    /**
     * Get the minimal key in the table.
     * @return The minimal key in the table.
     */
    abstract public K minKey();


    /**
     * Get the maximal key in the table.
     * @return The maximal key in the table.
     */
    abstract public K maxKey();


    /**
     * Return the rank of the key.
     * @param key The specific key.
     * @return Number of keys less than the specific key.
     */
    abstract public int rank(K key);


    /**
     * Retrive the ith key in the table.
     * @param i rank i.
     * @return key of rank i.
     */
    abstract public K select(int i);
}