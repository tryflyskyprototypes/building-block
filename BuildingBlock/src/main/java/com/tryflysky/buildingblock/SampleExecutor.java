package com.tryflysky.buildingblock;

import java.io.IOException;
import java.util.List;



public class SampleExecutor {




	public static void main(String[] args) throws IOException {

		Pile highest =  new Stacker().findHighest(readFile());

		List<String> result = highest.toString_originalStyle();

		for(String s : result) {
			System.out.println(s);
		}
	}








	/**
	 * パッケージ内のテキストファイルを選択
	 *
	 * 読み込むファイルを変更する場合は[fileName]を変更すれば良い
	 *
	 * @return
	 */
	private static String readFile() {

		final String packagePath = "/com/tryflysky/buildingblock/";
		final String ext = ".txt";

//		String fileName = "1";	//ファイル名は色数
//		String fileName = "2";
//		String fileName = "3";
		String fileName = "10";

		return packagePath + fileName + ext;
	}
}
