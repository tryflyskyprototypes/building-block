package com.tryflysky.buildingblock;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.tryflysky.buildingblock.Pile;
import com.tryflysky.buildingblock.Stacker;


public class StackerTest {


	@Test
	public void stackAllBlocks() {

		Stacker stacker = new Stacker();
		List<String> contents = mockFile();
		Pile pile = stacker.stackAllBlocks(new Blocks(contents), 0);

		String[] expects = {
				"  4 R ( 2 :  9)",
				"  5 Ba( 9 :  4)",
				"  7 R ( 4 :  8)",
				"  8 F ( 8 :  1)",
				" 10 F ( 1 :  3)",
		};

		List<String> actuals = pile.toString_originalStyle();

		assertEquals(expects.length, actuals.size());

		for(int i = 0; i < expects.length; i++) {

			assertEquals(expects[i], actuals.get(i));
		}
	}








	private List<String> mockFile() {

		List<String> mockContents = new LinkedList<String>();
		mockContents.add("9 6 4 3 9 3");
		mockContents.add("8 9 9 6 8 7");
		mockContents.add("3 7 3 9 9 10");
		mockContents.add("4 3 9 2 9 9");
		mockContents.add("4 9 7 6 1 4");
		mockContents.add("7 1 9 3 3 10");
		mockContents.add("3 9 8 4 3 3");
		mockContents.add("8 1 4 5 9 4");
		mockContents.add("6 9 7 5 6 5");
		mockContents.add("1 3 4 5 3 7");

		return mockContents;
	}

}
