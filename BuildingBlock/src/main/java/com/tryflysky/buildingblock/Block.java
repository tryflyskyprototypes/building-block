package com.tryflysky.buildingblock;

public class Block {

	//本当はenumがいいけど、速度重視ということで
	public static final int FRONT = 0;
	public static final int BACK = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int TOP = 4;
	public static final int BOTTOM = 5;
	public static final int FACE_NUM = 6;			//立方体の面の数

//	public static final int UPPER_SIDE = 0;
//	public static final int BOTTOM_SIDE = 1;

	private final String[] faceColors;
	private final int weight;

	private int upperSide;


	//TODO コンフィグへ移動
	private int[] opossiteSide = {BACK, FRONT, RIGHT, LEFT, BOTTOM, TOP};






	public Block(String[] faceColors, int weight) {

		this.faceColors = faceColors;
		this.weight = weight;

		upperSide = FRONT;
	}




	public String colorOf(int face_index) {

		return faceColors[face_index];
	}





	public int rotate() {

		if(upperSide < FACE_NUM){

			upperSide++;
		}

		return upperSide;
	}




	public int currentUpperSide() {

		return upperSide;
	}


	public int currentBottomSide() {

		return opossiteSide[upperSide];
	}



	public int weight() {

		return weight;
	}




	public boolean hasNextFace() {

		return currentUpperSide() < FACE_NUM;
	}




	public void changeUpperSide(int upperSide) {

		this.upperSide = upperSide;
	}




	public String colorOfUpperSide() {

		return colorOf(currentUpperSide());
	}




	public String colorOfBottomSide() {

		return colorOf(currentBottomSide());
	}




	public String toParamStr() {

		StringBuilder param = new StringBuilder();

		for(String c : faceColors) {
			param.append(c).append(FileGenerator.DELIMITER);
		}

		return param.toString().trim();
	}




	/*public String[] colorOfUpperAndBottom() {

		return new String[]{colorOfUpperSide(), colorOfBottomSide()};
	}*/




	public int oppositeSideOf(int uppersideFace) {

		if(uppersideFace % 2 == 0) {

			return uppersideFace + 1;
		}


		return uppersideFace - 1;
	}


}
