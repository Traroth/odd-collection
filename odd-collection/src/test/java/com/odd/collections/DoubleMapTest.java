package com.odd.collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleMapTest {

	@Test
	public void test() {
		DoubleMap<String, String> map = new DoubleMap<>();

		map.put("yo", "buddy");
		
		assertEquals(map.get("yo"), "buddy");
	}

}
