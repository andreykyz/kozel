package ru.devhead.goatgame.logic;

import java.util.LinkedList;

import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.AbstractBoard.CardGamerPair;
import ru.devhead.goatgame.logic.brain.Gamer;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.Player;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class SimpleBoard extends AbstractBoard implements Runnable {

	public SimpleBoard(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
	}
	public void StartGame() {

//		Display display = new DisplayWrapper();
		CardBatch batchForGame = new CardBatch();
		batchForGame.fillCardBatch();
		display.printBottom(true, batchForGame);

		table = new Card[4];
		cardGamerPairs = new CardGamerPair[4];
		// LinkedList

		// Создание виртуальных игроков и колоды для пользователя
		player = new Player(display, 0);
		player.setName("Player");
		leftBrain = new StupidBumpkin(null, 1);
		leftBrain.setName("Left Brain");
		friendBrain = new StupidBumpkin(null, 2);
		friendBrain.setName("Friend Brain");
		rightBrain = new StupidBumpkin(null, 3);
		rightBrain.setName("Right Brain");

		gamers = new Gamer[4];
		gamers[0] = player;
		gamers[1] = leftBrain;
		gamers[2] = friendBrain;
		gamers[3] = rightBrain;

		team1 = new GamersTeam(player, friendBrain);
		team2 = new GamersTeam(leftBrain, rightBrain);

		// Первая раздача колоды
		for (int i = 0; i < batchForGame.size(); i++) {
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				player.setTrumpSetterFlag(true);
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
				player.setTrumpSetterFlag(true);
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
		display.printText("-----");
		display.printTrumpSuit(new Card(trump));
		display.printText("-----");

		display.printText("Start game!!!");
		display.printText("-----");
		// game loop

		do {
			for (int i = 0; i < 7; i++) {
				LinkedList<Gamer> gamersQueue = getGamersQueue(firstGamer);
				for (int j = 0; j < 4; j++) {
					// Get next gamer from Queue
					Gamer gamer = gamersQueue.removeFirst();
					table[j] = gamer.turn(table, j);
					cardGamerPairs[j] = new CardGamerPair(gamer, table[j]);
					display.printTurnCard(table[j]);
				}
				firstGamer = whoBeat(cardGamerPairs);
				if (team1.haveGamer(firstGamer)) {
					team1.addBeatCards(table);
				} else {
					team2.addBeatCards(table);
				}

			}
			tempPoints = 0;
			if (team1.getCash() < 60) {
				tempPoints = 2;
				if (team1.getCash() < 60) {
					tempPoints = 4;
					if (team1.getCash() == 0) {
						tempPoints = 6;
					}
				}
				if (dublePoint) {
					dublePoint = false;
					tempPoints = tempPoints * 2;
				}
				team1.addPoints(tempPoints);
			} else if (team2.getCash() < 60) {
				tempPoints = 2;
				if (team2.getCash() < 60) {
					tempPoints = 4;
					if (team2.getCash() == 0) {
						tempPoints = 6;
					}
				}
				if (dublePoint) {
					dublePoint = false;
					tempPoints = tempPoints * 2;
				}
				team2.addPoints(tempPoints);
			}

			if (team1.getCash() == 60) {
				// Следующий Points умножается на 2
				dublePoint = true;
			}

		} while (team1.getPoints() < 12 && team2.getPoints() < 12);
		if (team1.getPoints()>=12) {
			display.printText("Player and Friend player - poor");
		} else {
			display.printText("Left gamer and Right gamer - poor");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
