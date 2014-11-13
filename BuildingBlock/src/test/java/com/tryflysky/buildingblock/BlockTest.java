package com.tryflysky.buildingblock;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlockTest {

	@Test
	public void oppositeSideOf() {

		Block block = new Block(null, 0);
		
		int[] expects = {1, 0, 3, 2, 5, 4};
		
		for(int i = 0; i < Block.FACE_NUM; i++) {
			
			assertEquals(expects[i], block.oppositeSideOf(i));
		}
	
	}

}
