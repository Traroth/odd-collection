package com.odd.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface BijectiveMap<K, V> extends Map<K, V> {
	
	public K getKey(V value);
	
	public Set<V> valueSet();
	
	public Collection<K> keys();
	
	public K removeKey(V value);
	
	@Override
	public default void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException("putAll() is not supported by Bijective Maps");
	}

}
