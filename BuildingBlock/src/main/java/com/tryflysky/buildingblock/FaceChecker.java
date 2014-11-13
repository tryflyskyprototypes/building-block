package com.tryflysky.buildingblock;

import java.util.ArrayList;
import java.util.List;

public class FaceChecker {





	public List<Integer> checkWorthTryFaces(Block block, int uppersideFace) {

		boolean[] uselessTry = toFlagArray(block, uppersideFace);


		List<Integer> worthTryFaces = new ArrayList<Integer>();

		for(int i = 0; i < uselessTry.length; i++) {

			if(uselessTry[i]) {
				continue;
			}

			worthTryFaces.add(i);
		}

		return worthTryFaces;
	}





	boolean[] toFlagArray(Block block, int uppersideFace) {

		boolean[] uselessTry = new boolean[Block.FACE_NUM];

		final int oppositeSideFace = block.oppositeSideOf(uppersideFace);

		final String upperSideColor = block.colorOf(uppersideFace);
		final String oppositeFaceColor = block.colorOf(oppositeSideFace);

		if( ! upperSideColor.equals(oppositeFaceColor)) {

			uselessTry[block.oppositeSideOf(uppersideFace)] = true;
		}

		for(int i = 0; i < uselessTry.length; i++) {

			if(i <= uppersideFace) {
				uselessTry[i] = true;
				continue;
			}

			if(uppersideFace % i != 0) {
				continue;
			}

			final String currentFaceColor = block.colorOf(i);
			final String currentOppositeFaceColor = block.colorOf(block.oppositeSideOf(i));

			if(upperSideColor.equals(currentFaceColor) && oppositeFaceColor.equals(currentOppositeFaceColor)
					|| upperSideColor.equals(currentOppositeFaceColor) && oppositeFaceColor.equals(currentFaceColor)) {

				uselessTry[i] = true;
				uselessTry[block.oppositeSideOf(i)] = true;
			}
		}

		return uselessTry;
	}
}

