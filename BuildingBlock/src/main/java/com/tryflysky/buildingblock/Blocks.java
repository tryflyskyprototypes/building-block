package com.tryflysky.buildingblock;

import java.util.Collections;
import java.util.List;

public class Blocks {

	private final BlockGenerator generator = new BlockGenerator();
	private final List<String> contents;


	public Blocks(List<String> contents) {

		this.contents = Collections.unmodifiableList(contents);
	}




	public Block getHeaviest() {

		final String heaviest = contents.get(contents.size() - 1);		//現状は小さい順に入ってる前提なのでこれで良い

		return generator.toBlock(heaviest, contents.size());
	}







	public List<Block> getLighterThan(int weight) {

		final int elementIndex = weight - 1;		//Blockのweightは[1]開始となっている
		final int begenIndex = elementIndex -1;	//指定されたweight"未満"を返したいのでさらに1減らす

		List<Block> candidates = generator.toListFromBigSize(contents, begenIndex);

		return Collections.unmodifiableList(candidates);
	}

}
