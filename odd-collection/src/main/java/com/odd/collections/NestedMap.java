package com.odd.collections;

public class NestedMap implements MultiDimMap {
	
	Entry[] array;

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public class Entry {
		private NestedMap nested;

		public NestedMap getNested() {
			return nested;
		}

		public void setNested(NestedMap nested) {
			this.nested = nested;
		}
	}

}
