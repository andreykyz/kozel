package ru.devhead.goatgame.logic;

import java.util.Iterator;

import ru.devhead.goatgame.display.Console;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class Board {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Console display = new Console();
		boolean trumpSetterFlag=false;//true - если пользователь назначал козыря
		CardBatch batchForGame = new CardBatch();
		batchForGame.fillCardBatch();
		display.print(batchForGame);

		//Создание виртуальных игроков и колоды для пользователя
		CardBatch myBatch = new CardBatch();
		StupidBumpkin friendBrain = new StupidBumpkin();
		StupidBumpkin leftBrain = new StupidBumpkin();
		StupidBumpkin rightBrain = new StupidBumpkin();

		// Раздача колоды		
		Card[] batchForGameAr = (Card[]) batchForGame.toArray();
		for (int i=0; i<batchForGameAr.length;i++) {
			if (batchForGameAr[i].faceId == CardsNames.JACK_CROSSES){
			}
			myBatch.add(batchForGameAr[i++]);
			leftBrain.pushCard(batchForGameAr[i++]);
			friendBrain.pushCard(batchForGameAr[i++]);
			rightBrain.pushCard(batchForGameAr[i]);
		}

	}

}
