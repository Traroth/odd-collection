package com.odd.collections;

import java.util.AbstractList;
import java.util.Collection;

public class ChunkyList<T> extends AbstractList<T> {
	
protected Chunk firstChunk;
	
	protected Chunk lastChunk;
	
	protected int chunkSize;
	
	protected int size;
	
	protected class Chunk {
		
		protected T[] array;
		
		protected int used;
		
		protected Chunk previousChunk;
		
		protected Chunk nextChunk;
		
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
		
	}
	
	public ChunkyList() {
		this(DEFAULT_CHUNK_SIZE);
	}
	
	public ChunkyList(int chunkSize) {
		this.chunkSize = chunkSize;
	}
	
	public ChunkyList(Collection<? extends T> c) {
		//TODO
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void add(int index, T element) {
		
	}
	
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	

	protected static int DEFAULT_CHUNK_SIZE = 10;

}
