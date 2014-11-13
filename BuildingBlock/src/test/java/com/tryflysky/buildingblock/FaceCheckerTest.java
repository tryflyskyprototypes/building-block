package com.tryflysky.buildingblock;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaceCheckerTest {

	FaceChecker checker = new FaceChecker();

	@Test
	public void checkWorthTryFaces() {

		final String[] mock_1 = {"1", "2", "2", "1", "1", "2"};
		final boolean[] expects_1 = {true, true, true, true, true, true};

		test(mock_1, expects_1);




		final String[] mock_2 = {"1", "2", "3", "1", "1", "4"};
		final boolean[] expects_2 = {true, true, false, false, false, false};

		test(mock_2, expects_2);
	}



	//TODO rename
	private void test(String[] mock, boolean[] expects) {

		Block block = new Block(mock, 0);

		boolean[] uselessTryFace = checker.toFlagArray(block, 0);

		for(int i = 0; i < uselessTryFace.length; i++) {

			System.out.println(expects[i] + " : " + uselessTryFace[i]);

			assertEquals(expects[i], uselessTryFace[i]);
		}

		System.out.println();
		System.out.println();
	}

}
