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
}