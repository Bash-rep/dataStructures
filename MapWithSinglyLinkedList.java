package dataStructures;

public class MapWithSinglyLinkedList<K, V> implements Map<K, V> {
	List<Entry<K, V>> elements;
	int counter;
	public MapWithSinglyLinkedList() {
		elements = new SinglyLinkedList<>();
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public Iterator<K> keys() throws NoElementException {
		return new KeyIterator<K, V>(iterator());
	}

	@Override
	public Iterator<V> values() throws NoElementException {
		return new ValuesIterator<K, V>(iterator());
	}

	@Override
	public V find(K key) {
		int index = findIndex(key);
		if (index > -1)
			return elements.get(index).getValue();
		return null;
	}

	@Override
	public V insert(K key, V value) {
		Entry<K, V> entry = new EntryClass<>(key, value);
		elements.addFirst(entry);
		return value;
	}

	@Override
	public V remove(K key) {
		int index = findIndex(key);
		if(index > -1)
			return elements.remove(index).getValue();
		return null;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() throws NoElementException {
		return elements.iterator();
	}

	private int findIndex(K key) {
		for (int i = 0; i < elements.size(); i++) {
			Entry<K, V> e = elements.get(i);
			if (e.getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}

}
