package com.odd.collections;

import java.util.AbstractList;
import java.util.Collection;

public class ChunkyList<T> extends AbstractList<T> {
	
	private Chunk firstChunk;
	
	private Chunk lastChunk;
	
	private int chunkSize;
	
	private int size;
	
	private class Chunk {
		
		private T[] array;
		
		private int used;
		
		private Chunk previousChunk;
		
		private Chunk nextChunk;
		
		public Chunk() {
			array = (T[]) new Object[chunkSize];
			used = 0;
		}

		public Chunk getPreviousChunk() {
			return previousChunk;
		}

		public void setPreviousChunk(Chunk previousChunk) {
			this.previousChunk = previousChunk;
		}

		public Chunk getNextChunk() {
			return nextChunk;
		}

		public void setNextChunk(Chunk nextChunk) {
			this.nextChunk = nextChunk;
		}

		public T[] getArray() {
			return array;
		}

		public void setArray(T[] array) {
			this.array = array;
		}

		public int getUsed() {
			return used;
		}

		public void setUsed(int used) {
			this.used = used;
		}
		
		public void shift(int begin, int end, int step) {
			for (int i=end; i>=begin; i--) {
				array[i+step] = array[i];
			}
		}
	}
	
	public ChunkyList() {
		this(DEFAULT_CHUNK_SIZE);
	}
	
	public ChunkyList(int chunkSize) {
		this.chunkSize = chunkSize;
		
		Chunk first = new Chunk();
		firstChunk = first;
		lastChunk = first;
		
		size = 0;
	}
	
	public ChunkyList(Collection<? extends T> c) {
		//TODO
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void add(int index, T element) {
		if (index > size) {
			throw new IndexOutOfBoundsException("index: "+index+" ; size: "+size);
		}
		
		
		
	}
	
	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void insertNewChunk(Chunk previous, Chunk next) {
		Chunk newChunk = new Chunk();
		
		previous.setNextChunk(newChunk);
		next.setPreviousChunk(newChunk);
		
		newChunk.setPreviousChunk(previous);
		newChunk.setNextChunk(next);
	}
	
	private void insert(Chunk chunk, T element, int positionInChunk) {
		int toMove = chunkSize - chunk.getUsed();
		
		if (toMove > 0) {
			
		}
	}
	
	private Chunk findChunk(int index) {
		// TODO optimize by starting at the end when faster
		boolean b = true;
		
		while (b) {
			
		}
	}

	private static int DEFAULT_CHUNK_SIZE = 10;

}
