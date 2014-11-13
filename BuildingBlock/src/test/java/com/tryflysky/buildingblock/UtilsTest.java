package com.tryflysky.buildingblock;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

	BlockGenerator generator = new BlockGenerator();

	@Test
	public void isSameColor() {

		final String mockParam = "1 2 3 4 5 6";
		final int mockWeight = 101;

		Block original = generator.toBlock(mockParam, mockWeight);

		//下準備
		assertTrue(original.colorOfUpperSide().equals("1"));
		assertEquals(original.colorOfUpperSide(), "1");
		original.rotate();
		original.rotate();
		assertEquals(original.colorOfUpperSide(), "3");

		Block clone = Utils.cloneBlock(original);
		assertEquals(original.colorOfUpperSide(), clone.colorOfUpperSide());


	}

}
