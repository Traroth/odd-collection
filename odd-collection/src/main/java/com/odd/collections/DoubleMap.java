package com.odd.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DoubleMap<K, V> implements BijectiveMap<K, V> {

	private Map<K, V> straight;
	
	private Map<V, K> reverse;
	
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
		V candidateValue = straight.get(key);
		K candidateKey = reverse.get(value);
		
		if (candidateKey==null && candidateValue==null) {
			straight.put(key, value);
			reverse.put(value, key);
			
			return null;
		} else if (candidateKey==null && candidateValue!=null) {
			V curV = straight.put(key,  value);
			reverse.remove(curV);
			reverse.put(value, key);
			
			return curV;
		} else if (candidateKey!=null && candidateValue==null) {
			K curK = reverse.put(value, key);
			straight.remove(curK);
			straight.put(key, value);
			
			return null;
		} else if (!(value.equals(candidateValue) && key.equals(candidateKey))) {
			throw new IllegalArgumentException("Key and value are both present, but not in the same pair. Impossible to but that pair in the map");
		} else {
			return value;
		}
	}

	@Override
	public V remove(Object key) {
		V value = straight.remove(key);
		
		if (value != null) {
			reverse.remove(value);
		}
		
		return value;
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
		K key = reverse.remove(value);
		
		if (key != null) {
			straight.remove(key);
		}
		
		return key;
	}
	
}
