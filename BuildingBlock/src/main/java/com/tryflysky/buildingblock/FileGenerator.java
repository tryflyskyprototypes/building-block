package com.tryflysky.buildingblock;

import java.util.Random;

public class FileGenerator {



	private final int GENERATE_NUM = 500;

	public static final int COLOR_VALIATION_NUM = 10;	//立方体の面の色の数
	public static final String DELIMITER = " ";

	Random random = new Random();





	private void printBlocks(int generateNum) {

		for(int i = 0; i < generateNum; i++) {

			System.out.println(generateBlock());
		}
	}




	private String generateBlock() {

		StringBuilder result = new StringBuilder();

		for(int i = 0; i < Block.FACE_NUM; i++) {

			int color = random.nextInt(COLOR_VALIATION_NUM) + 1;

			result.append(color).append(DELIMITER);
		}

		return removeLastDelimiter(result.toString());
	}







	private String removeLastDelimiter(String string) {

		return string.trim();
	}







	public static void main(String[] args) {

		FileGenerator generator = new FileGenerator();

		generator.printBlocks(generator.GENERATE_NUM);

	}

}
