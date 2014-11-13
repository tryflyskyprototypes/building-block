package com.tryflysky.buildingblock;

import java.util.LinkedList;
import java.util.List;

public class BlockGenerator {





	/*public List<Block> toListFromBigSize(List<String> contents) {

		List<Block> reverse = new LinkedList<Block>();

		for(int i = contents.size() -1; i >= 0; i--) {

			reverse.add(toBlock(contents.get(i), (i + 1)));
		}


		return reverse;
	}*/

	public List<Block> toListFromBigSize(List<String> contents, int beginIndex) {

		List<Block> reverse = new LinkedList<Block>();

		for(int i = beginIndex; i >= 0; i--) {

			reverse.add(toBlock(contents.get(i), (i + 1)));
		}

		return reverse;
	}









	public Block toBlock(String blockParam, int weight) {

		return new Block(blockParam.split(FileGenerator.DELIMITER), weight);
	}



}
