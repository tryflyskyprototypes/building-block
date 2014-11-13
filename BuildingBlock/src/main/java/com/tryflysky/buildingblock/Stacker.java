package com.tryflysky.buildingblock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




/**
 * ブロックの積み上げ実行クラス
 *
 *
 */
//TODO ブロックの違う面に同じ色があった場合の積み上げに対応
public class Stacker {


	private FaceChecker faceChecker = new FaceChecker();



	public Pile findHighest(final String fullPath) throws IOException {

		List<String> contents = new FileReader().read(fullPath);

		return findHighest(contents);
	}


	/*public Pile findHighest(List<String> contents) {

		List<Pile> piles = tryAllPattern(contents);

		return selectHighest(piles);
	}*/
	public Pile findHighest(List<String> contents) {

		Piles piles = tryAllPattern(contents);

		return piles.getHighest();
	}






	/*public Pile stackAllBlocks(List<String> contents, final int bottomBlockupperSide) {

		Blocks blocks = new Blocks(contents);

		Block bottom = blocks.getHeaviest();
		bottom.changeUpperSide(bottomBlockupperSide);

		Pile pile = new Pile(bottom);

		List<Block> candidates = blocks.getLighterThan(bottom.weight());

		for(Block candidate : candidates) {

			pile.add(pickNextBlock(pile.topBlock(), candidate));
		}

		return pile;
	}*/
	public Pile stackAllBlocks(Blocks blocks, final int bottomBlockupperSide) {

		Block bottom = blocks.getHeaviest();
		bottom.changeUpperSide(bottomBlockupperSide);

		Pile pile = new Pile(bottom);

		List<Block> candidates = blocks.getLighterThan(bottom.weight());

		for(Block candidate : candidates) {

			pile.add(pickNextBlock(pile.topBlock(), candidate));
		}

		return pile;
	}









	/*private List<Pile> tryAllPattern(List<String> contents) {

		List<Pile> piles = new ArrayList<Pile>();

		for(int i = 0; i < Block.FACE_NUM; i++) {

			piles.add(stackAllBlocks(contents, i));
		}

		return piles;
	}*/
	private Piles tryAllPattern(List<String> contents) {

		Piles piles = new Piles();

		//TODO 底のブロックも同じ色の面を試す必要はない
		for(int i = 0; i < Block.FACE_NUM; i++) {

			Blocks blocks = new Blocks(contents);

			//TODO 試すだけ無駄な面を省く
//			List<Integer> worthTryFaces = faceChecker.checkWorthTryFaces(blocks.getHeaviest(), i);

			Pile piled = stackAllBlocks(blocks, i);

			piles.add(piled);

			//TODO 他の積み上げ方を試す
//			final int weight_next_heavy = contents.size() - 2;
//			piles.addAll(tryAnotherPattern(piled, contents, weight_next_heavy));

		}

		return piles;
	}










	/*private List<Pile> tryAnotherPattern(Pile piled, List<String> contents, final int weight_next_heavy) {

		final Block nextHeaby = piled.getBlock(piled.height() - 2);	//TODO 可変に

		final String[] upperAndBottomColor = nextHeaby.colorOfUpperAndBottom();

		while(nextHeaby.hasNextFace()) {

			nextHeaby.rotate();

			if(uselessTry(upperAndBottomColor, nextHeaby)) {
				continue;
			}

			//指定より重いブロックを取得
			Pile anotherPatternPile = piled.getHeavierThan(weight_next_heavy);

			//TODO 積み上げる
			//別に積み上げて結合した方が楽
			anotherPatternPile.add(nextHeaby);

		}


		return null;
	}*/











	private Block pickNextBlock(Block currentTopBlock, Block candidate) {

		while(candidate.hasNextFace()) {

			if(Utils.isSameColor(currentTopBlock, candidate)) {

				return candidate;
			}

			candidate.rotate();
		}

		return null;
	}








}


/*
○言語・環境など：
不問
ただし、コンパイル方法、実行方法など特殊な設定をする必要がある場合は、そ
の旨を、README.mdなど分かる場所に記載してください。

○評価方法：
今回も速度を最重要項目として評価します。

------ 以下、コンテストのお題の詳細です。------

--
６面に色が付いた全て同じ大きさだが、全て重さが異なるブロックをなるべく高 く積み上げる方法を計算してください．
積み上げる際に以下のルールがあります．
１．積み上げる箱は，その下の箱よりも軽い箱でなければならない
２．各箱と箱の接している面は，同じ色でなければならない
※全ての接面の色を揃える必要はない。例えば、３段積み上げた際に、１段目と ２段目の接面の色と、２段目と３段目の色は異なって構わない。

○入力
先頭行に箱の数を表す整数(1 - 500)
次の行から，箱の軽い順に１行に１つの箱の情報
１つの箱の情報は，６つの整数(1 - 100)で構成されており，それぞれ，正面
(front)，背面(back)，左側面(left)，右側面(right)，上面(top)，底面
(bottom)の色を表現しています．

例）
3
1 1 1 2 2 2
3 3 3 3 3 3
1 2 3 1 2 3

上記の例は、３つの箱が与えられた例です。
１番軽い箱は、正面、背面、左側面が１の色、右側面、上面、底面が２の色
２番目に軽い箱は、全面が３の色
３番めに軽い箱（一番重い箱）は、正面、右側面が１の色、背面、上面が２の 色、左側面、底面が３の色
という箱の積み上げを実施してください。

○出力
先頭行に積み上げられる箱の最大数
次の行から，積み上げた箱の情報を上から順番に出力
１つの箱の情報は，何番目の箱かを示すインデックス(1始まり)と，どの面を上
向きに重ねるかを出力

例）入力の例に対する出力例
2
1 front
3 right

この出力例では、２段積み上げるのが高さ最大となることを示し、その積み上げ 方としては、
１番の箱（入力で２行目）の正面を上向きにして、その下に、３番めの箱（入力 の４行目）の右側面を上にして積み上げることを示しています。この場合の箱の 接面は両方の箱ともに１の色になっていることに注意してください。

同一の高さで積み上げ方が複数存在する場合は，どの積み上げ方でもOKです．
そのため、

2
2 back
3 left

という出力でも正解です。
--

------ ここまで、コンテストのお題の詳細 ------
*/

