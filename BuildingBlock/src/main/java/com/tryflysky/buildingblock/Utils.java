package com.tryflysky.buildingblock;

public class Utils {


	private Utils() {
		//static method only
	}


	private static BlockGenerator blockGenerator = new BlockGenerator();



	/**
	 * 色が同じなら真
	 *
	 * 下のブロックの上面
	 * 上に置こうとするブロックの下面
	 *
	 * @param top_of_pile
	 * @param candidate
	 * @return
	 */
	public static boolean isSameColor(Block top_of_pile, Block candidate) {

		final String color_top = top_of_pile.colorOf(top_of_pile.currentUpperSide());
		final String color_candidate = candidate.colorOf(candidate.currentBottomSide());

		return color_top.equals(color_candidate);
	}









	public static Block cloneBlock(Block original) {

		System.out.println( original.toParamStr());

		Block clone = blockGenerator.toBlock(original.toParamStr(), original.weight());
		clone.changeUpperSide(original.currentUpperSide());

		return clone;
	}







}
