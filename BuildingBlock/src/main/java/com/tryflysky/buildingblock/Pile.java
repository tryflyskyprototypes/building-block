package com.tryflysky.buildingblock;

import java.util.LinkedList;
import java.util.List;



/**
 * 積んだブロックの山
 *
 * @author admin
 *
 */
public class Pile {

	private final String[] BLOCK_FACE = {"F ", "Ba", "L ", "R ", "T ", "Bo"};

	private List<Block> stacked = new LinkedList<Block>();




	public Pile(Block bottom) {

		stacked.add(bottom);
	}








	public Pile() {
	}








	public Block topBlock() {

		return stacked.get(stacked.size() - 1);
	}







	public void add(Block candidate) {

		if(candidate != null) {

			stacked.add(candidate);
		}
	}







	/*public void displayAsOriginalStyle() {

		final int colorVariation_digit = String.valueOf(FileGenerator.COLOR_VALIATION_NUM).length();
		final String blank_digit = " ";

		for(int i = stacked.size() - 1; i >= 0; i--) {

			Block b = stacked.get(i);

			System.out.println(
					arrangeDigit(3, blank_digit,  b.weight())
					+ " "
					+ BLOCK_FACE[b.currentUpside()]
							+ "("
							+ arrangeDigit(colorVariation_digit, blank_digit, b.colorOf(b.currentUpside()))
							+ " : "
							+ arrangeDigit(colorVariation_digit, blank_digit, b.colorOf(b.currentBottomSide()))
							+ ")"
					);
		}
	}*/







	public List<String> toString_originalStyle() {

		List<String> results = new LinkedList<String>();

		final int colorVariation_digit = String.valueOf(FileGenerator.COLOR_VALIATION_NUM).length();
		final String blank_digit = " ";

		for(int i = stacked.size() - 1; i >= 0; i--) {

			Block b = stacked.get(i);

			results.add(
					arrangeDigit(3, blank_digit,  b.weight())
					+ " "
					+ BLOCK_FACE[b.currentUpperSide()]
							+ "("
							+ arrangeDigit(colorVariation_digit, blank_digit, b.colorOf(b.currentUpperSide()))
							+ " : "
							+ arrangeDigit(colorVariation_digit, blank_digit, b.colorOf(b.currentBottomSide()))
							+ ")"
					);
		}

		return results;
	}








	private String arrangeDigit(int digit, String fillout, String color) {

		return arrangeDigit(digit, fillout, Integer.parseInt(color));
	}








	private String arrangeDigit(int digit, String fillout, int num) {

		final int filloutLength = digit - String.valueOf(num).length();

		StringBuilder arranged = new StringBuilder();
		for(int i = 0; i < filloutLength; i++) {

			arranged.append(fillout);
		}

		arranged.append(num);

		return arranged.toString();
	}








	public int height() {

		return stacked.size();
	}








	public Block getBlock(int position) {

		return Utils.cloneBlock(stacked.get(position));
	}







	public Pile getHeavierThan(int weight) {

		Pile heaviers = new Pile();

		for(Block block : stacked) {

			if(block.weight() > weight) {
				heaviers.add(block);
			}

//			heaviers.add(block);
		}

		return heaviers;
	}








}
