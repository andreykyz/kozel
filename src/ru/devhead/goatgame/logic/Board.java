package ru.devhead.goatgame.logic;

import ru.devhead.goatgame.display.Console;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class Board {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		Console display = new Console();

		CardBatch batchForGame = new CardBatch();
		batchForGame.fillCardBatch();


		//Создание виртуальных игроков и колоды для пользователя
		CardBatch myBatch = new CardBatch();
		StupidBumpkin friendBrain = new StupidBumpkin();
		StupidBumpkin leftBrain = new StupidBumpkin();
		StupidBumpkin rightBrain = new StupidBumpkin();

		// Раздача колоды		
		for (int i=0; i<batchForGame.size();i++) {
			myBatch.add(batchForGame.get(i++));
			leftBrain.pushCard(batchForGame.get(i++));
			friendBrain.pushCard(batchForGame.get(i++));
			rightBrain.pushCard(batchForGame.get(i));
		}
		
	}

}
