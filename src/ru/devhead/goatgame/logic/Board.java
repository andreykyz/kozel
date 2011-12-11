package ru.devhead.goatgame.logic;

import java.util.LinkedList;

import org.apache.log4j.BasicConfigurator;

import ru.devhead.goatgame.display.Console;
import ru.devhead.goatgame.logic.brain.ConsolePlayer;
import ru.devhead.goatgame.logic.brain.Gamer;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class Board {

	/**
	 * @param args
	 */

	int stepNum = 0;
	static int trump = CardsNames.DIAMONDS;

	Gamer firstGamer;
	int gamersCounter;

	Gamer player;
	Gamer leftBrain;
	Gamer friendBrain;
	Gamer rightBrain;

	public Board() {

		Console display = new Console();
		boolean trumpSetterFlag = false;
		CardBatch batchForGame = new CardBatch();
		batchForGame.fillCardBatch();
		display.print(batchForGame);

		LinkedList<Card> table;
		// LinkedList

		// Создание виртуальных игроков и колоды для пользователя
		player = new ConsolePlayer(display, 0);
		leftBrain = new StupidBumpkin(1);
		friendBrain = new StupidBumpkin(2);
		rightBrain = new StupidBumpkin(3);

		// Первая раздача колоды
		for (int i = 0; i < batchForGame.size(); i++) {
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				trumpSetterFlag = true;
				friendBrain.setTrumpSetterFlag(true);
				trump = player.assignTrump();
				setFirstGamer(player);
			}
			player.pushCard(batchForGame.get(i++));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				leftBrain.setTrumpSetterFlag(true);
				rightBrain.setTrumpSetterFlag(true);
				trump = leftBrain.assignTrump();
				setFirstGamer(leftBrain);
				
			}
			leftBrain.pushCard(batchForGame.get(i++));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				trumpSetterFlag = true;
				friendBrain.setTrumpSetterFlag(true);
				trump = friendBrain.assignTrump();
				setFirstGamer(friendBrain);
			}
			friendBrain.pushCard(batchForGame.get(i++));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				leftBrain.setTrumpSetterFlag(true);
				rightBrain.setTrumpSetterFlag(true);
				trump = rightBrain.assignTrump();
				setFirstGamer(rightBrain);
			}
			rightBrain.pushCard(batchForGame.get(i));

		}
		leftBrain.setTrump(trump);
		friendBrain.setTrump(trump);
		rightBrain.setTrump(trump);
		display.println("-----");
		display.printSuit(new Card(trump));
		display.println("-----");

		display.print("Start game!!!");
		for (int i = 0; i < 7; i++) {
			// display.print(player.getbatchOnHand());

		}

	}

	void setFirstGamer(Gamer gamer) {
		firstGamer = gamer;
		gamersCounter = gamer.getId();
	}

	Gamer getNextGamer() {
		if (gamersCounter == 0) {

		}
		return null;

	}

}
