import java.util.Iterator;
import java.util.ArrayList;

/**
 * Sorted Dictionary using an Array.
 */

public class DictionaryArray<K extends Comparable<? super K>,V> implements DictionaryInterface<K,V> {
	private final Entry<K,V> [] dictionary;
	private int size;
	
	public DictionaryArray() {
		Entry<K,V>[] tempDictionary = (Entry<K, V>[])new Entry[10];
		dictionary = tempDictionary;
		size = 0;
	}
	
	public V add(K key, V value) {
		int i = 0;
		while(dictionary[i] != null && key.compareTo(dictionary[i].getKey()) > 0) {
			i++;
		}
		
		if(dictionary[i] == null) {
			dictionary[i] = new Entry<>(key, value);
			size++;
		}
		else if(key.compareTo(dictionary[i].getKey()) == 0) {
			V temp = dictionary[i].getValue();
			dictionary[i].setValue(value);
			return temp;
		}
		else {
			for(int j = size; j > i; j--) {
				dictionary[j] = dictionary[j-1];
			}
			
			dictionary[i] = new Entry<>(key, value);
			size++;
		}
		
		return null;
	}
	
	public V remove(K key) {
		for (int i = 0; i < size; i++) {
			if (dictionary[i].getKey().equals(key)) {
				V thisValue = dictionary[i].getValue();
				
				if (i == size-1)
					dictionary[i] = null;
				else {
					for (int q = i; q < size-1; q++)
						dictionary[q] = dictionary[q+1];
					
					dictionary[size-1] = null;
				}
				
				size--;
				return thisValue;
			}
		}
		
		return null;
	}
	
	public V getValue(K key) {
		for(int i = 0; i < size; i++) {
			if(dictionary[i].getKey().equals(key))
				return dictionary[i].getValue();
		}
		
		return null;
	}
	
	public boolean contains(K key) {
		for(int i = 0; i < size; i++) {
			if(dictionary[i].getKey().equals(key))
				return true;
		}
		
		return false;
	}
	
	public Iterator<K> getKeyIterator() {
		ArrayList<K> array = new ArrayList<K>();
		
		for (int i = 0; i < size; i++)
			array.add(dictionary[i].getKey());
		
		Iterator<K> keyIterator = array.iterator();
		return keyIterator;
	}
	
	public Iterator<V> getValueIterator() {
		ArrayList<V> array = new ArrayList<V>();
		
		for (int i = 0; i < size; i++)
			array.add(dictionary[i].getValue());
		
		Iterator<V> valueIterator = array.iterator();
		return valueIterator;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void clear() {
		for(int i = 0; i < size; i++)
			dictionary[i] = null;
		
		size=0;
	}
	
	public class Entry<S, D> {
		private S key;
		private D value;
		
		private Entry(S sKey, D dValue) {
			key = sKey;
			value = dValue;
		}
		
		private S getKey() {
			return key;
		}
		
		private D getValue() {
			return value;
		}
		
		private void setValue(D nValue)	{
			value = nValue;
		}
		
	}
	
}