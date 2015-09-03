package container;

/**
 * An interface of table that maps keys to values.
 * No duplicate keys are permited.
 */
public interface Table<K, V> {

    /**
     * Put a key-value pair into the table.
     * If the key is already existed, replace it with new value.
     * @param key The key with with the specific value is associated.
     * @param value The speicific value associated with the key.
     * @return The previous value assicated with the key if existed, or else null.
     */
    abstract public V put(K key, V value);


    /**
     * Retrive the value to which the key is mapped.
     * @param key The specific key whose associated value is to be returned
     * @return The value associated if it is exist, or else null.
     */
    abstract public V get(K key);


    /**
     * Check if the table contains the specific key.
     * @param key The specific key to check.
     * @return true if the key is in the table.
     */
    abstract public boolean contains(K key);


    /**
     * Remove the key-value pair for a specific key from the table.
     * @param key The specific key to be removed.
     * @return The value to which the specific value is mapped, null if key not found.
     */
    abstract public V remove(K key);


    /**
     * Check if the table is empty.
     * @return true if it is empty.
     */
    abstract public boolean isEmpty();


    /**
     * Return the number of key-value pairs in the table.
     * @return The number of key-value pairs.
     */
    abstract public int size();
}