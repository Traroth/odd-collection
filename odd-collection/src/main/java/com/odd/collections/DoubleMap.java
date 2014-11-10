package com.odd.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DoubleMap<K, V> implements BijectiveMap<K, V> {

	Map<K, V> straight;
	
	Map<V, K> reverse;
	
	public DoubleMap() {
		straight = new HashMap<>();
		reverse = new HashMap<>();
	}

	@Override
	public int size() {
		return straight.size();
	}

	@Override
	public boolean isEmpty() {
		return straight.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return straight.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return reverse.containsKey(value);
	}

	@Override
	public V get(Object key) {
		return straight.get(key);
	}

	@Override
	public V put(K key, V value) {
		if (straight.containsKey(key)) {
			K reverseValue = reverse.get(straight.get(key));
			
			if (reverseValue == null) {
				
			} else if (!reverse.get(reverseValue).equals(key)) {
				//error
			} // else do nothing: key/value pair is already in the map
		} 
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		straight.clear();
		reverse.clear();
	}

	@Override
	public Set<K> keySet() {
		return straight.keySet();
	}

	@Override
	public Collection<V> values() {
		return straight.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return straight.entrySet();
	}

	@Override
	public K getKey(Object value) {
		return reverse.get(value);
	}

	@Override
	public Set<V> valueSet() {
		return reverse.keySet();
	}

	@Override
	public Collection<K> keys() {
		return reverse.values();
	}

	@Override
	public K removeKey(V value) {
		// TODO Auto-generated method stub
		return null;
	}

}
