package ru.devhead.goatgame.logic;

import java.util.LinkedList;

import ru.devhead.goatgame.display.Console;
import ru.devhead.goatgame.logic.brain.ConsolePlayer;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class Board {

	/**
	 * @param args
	 */

	int stepNum = 0;
	static int trump = CardsNames.DIAMONDS;
	
	public static void main(String[] args) {

		Console display = new Console();
		boolean trumpSetterFlag = false;
		CardBatch batchForGame = new CardBatch();
		batchForGame.fillCardBatch();
		display.print(batchForGame);

		LinkedList<Card> table;
//		LinkedList

		// Создание виртуальных игроков и колоды для пользователя
		ConsolePlayer player = new ConsolePlayer(display);
		StupidBumpkin friendBrain = new StupidBumpkin();
		StupidBumpkin leftBrain = new StupidBumpkin();
		StupidBumpkin rightBrain = new StupidBumpkin();

		// Первая раздача колоды
		for (int i = 0; i < batchForGame.size(); i++) {
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				trumpSetterFlag = true;
				friendBrain.setTrumpSetterFlag(true);
				trump = player.assignTrump();
			}
			player.pushCard(batchForGame.get(i++));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				leftBrain.setTrumpSetterFlag(true);
				rightBrain.setTrumpSetterFlag(true);
				trump = leftBrain.assignTrump();
			}
			leftBrain.pushCard(batchForGame.get(i++));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				trumpSetterFlag = true;
				friendBrain.setTrumpSetterFlag(true);
				trump = friendBrain.assignTrump();
			}
			friendBrain.pushCard(batchForGame.get(i++));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				leftBrain.setTrumpSetterFlag(true);
				rightBrain.setTrumpSetterFlag(true);
				trump = rightBrain.assignTrump();
			}
			rightBrain.pushCard(batchForGame.get(i));

		}
		leftBrain.setTrump(trump);
		friendBrain.setTrump(trump);
		rightBrain.setTrump(trump);
		System.out.println("-----");
		display.printSuit(new Card(trump));
		System.out.println("-----");

		display.print("Start game!!!");
		for (int i = 0; i < 7; i++) {
			//display.print(player.getbatchOnHand());
			
		}
		
		

	}

}
