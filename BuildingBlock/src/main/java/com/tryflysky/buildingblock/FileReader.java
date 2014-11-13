package com.tryflysky.buildingblock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class FileReader {




	public List<String> read(String fullPath) throws IOException {

		Class<? extends FileReader> c = this.getClass();	//これで相対パスを取得できる

		InputStream is = c.getResourceAsStream(fullPath);	//絶対パスで指定する場合  [ /PROJECT_NAME?/src ]は不要

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		List<String> result = new LinkedList<String>();

		while (br.ready()) {
			result.add(br.readLine());
		}

		return result;
	}


}
