package dataStructures;

public class LinearProbingHashTable<K, V> extends MapWithHashTable<K, V> {

	// The array of entries.
	protected Entry<K, V>[] table;

	public LinearProbingHashTable() {
		this(DEFAULTCAPACITY);
	}

	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(int capacity) {
		// Load factor is 1/2 (0.5)
		int arraySize = MapWithHashTable.nextPrime((int) (2 * capacity));
		// Compiler gives a warning.
		table = (Entry<K, V>[]) new Entry[arraySize];
		for (int i = 0; i < arraySize; i++)
			table[i] = null;
		maxSize = capacity;
		currentSize = 0;
	}

	@Override
	public Iterator<K> keys() throws NoElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> values() throws NoElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() throws NoElementException {
		// TODO Auto-generated method stub
		return null;
	}
//TODO
	@Override
	public V find(K key) {
		int i = hash((String) key);
		boolean found = false;
		while (!found) {
			if (table[i] == null)
				return null;
			else if (table[i].getKey().equals(key)) {
				return table[i].getValue();
			} else {
				i = i++ % maxSize;
			}
		}
		return null;
	}

	@Override
	public V insert(K key, V value) {
		int i = hash((String) key);
		boolean inserted = false;
		while (!inserted) {
			if (table[i] == null) {
				table[i] = new EntryClass<K, V>(key, value);
				inserted = true;
			} else {
				i++;
			}
		}
		currentSize++;
		return value;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
