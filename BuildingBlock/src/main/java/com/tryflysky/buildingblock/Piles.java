package com.tryflysky.buildingblock;

import java.util.ArrayList;
import java.util.List;

public class Piles {

	private List<Pile> piles = new ArrayList<Pile>();




	public Piles add(Pile pile) {

		piles.add(pile);

		return this;
	}




	public Pile getHighest() {

		int highest_height = 0;
		int highest_pile_index = 0;

		for(int i = 0; i < piles.size(); i++) {

			int height = piles.get(i).height();

			if(height > highest_height) {

				highest_height = height;
				highest_pile_index = i;
			}
		}

		return piles.get(highest_pile_index);
	}

}
