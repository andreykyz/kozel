package ru.devhead.goatgame.logic;

import java.util.LinkedList;

import ru.devhead.goatgame.display.CardWrapper;
import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.brain.Gamer;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.Player;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;
import ru.devhead.goatgame.logic.verification.CheatingType;
import ru.devhead.goatgame.logic.verification.Judge;

public class SimpleBoard extends AbstractBoard implements Runnable {

	public SimpleBoard(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
	}

	private void StartGame() {

		CardBatch batchForGame = new CardBatch();
		batchForGame.fillCardBatch();
		// display.printBottom(true, batchForGame);

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
			player.pushCard(new CardWrapper(batchForGame.get(i++)));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				leftBrain.setTrumpSetterFlag(true);
				rightBrain.setTrumpSetterFlag(true);
				display.printText("Please assign trump");
				trump = leftBrain.assignTrump();
				setFirstGamer(leftBrain);

			}
			leftBrain.pushCard(new CardWrapper(batchForGame.get(i++)));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				player.setTrumpSetterFlag(true);
				friendBrain.setTrumpSetterFlag(true);
				trump = friendBrain.assignTrump();
				setFirstGamer(friendBrain);
			}
			friendBrain.pushCard(new CardWrapper(batchForGame.get(i++)));
			if (batchForGame.get(i).getFaceId() == CardsNames.JACK_CROSSES) {
				leftBrain.setTrumpSetterFlag(true);
				rightBrain.setTrumpSetterFlag(true);
				trump = rightBrain.assignTrump();
				setFirstGamer(rightBrain);
			}
			rightBrain.pushCard(new CardWrapper(batchForGame.get(i)));

		}
		leftBrain.setTrump(trump);
		friendBrain.setTrump(trump);
		rightBrain.setTrump(trump);

		display.printTrumpSuit(new Card(trump));
		display.printText("Start game!!!");
		display.printBottom(true, player.getbatchOnHand());
		display.printLeft(false, leftBrain.getbatchOnHand());
		display.printTop(false, friendBrain.getbatchOnHand());
		display.printRight(false, rightBrain.getbatchOnHand());
		Judge judge;
		Gamer gamer;
		// game loop
		do {
			if (team1.getGamer1().getTrumpSetterFlag()) {
				judge = new Judge(new Card(trump), team1);
			} else {
				judge = new Judge(new Card(trump), team2);
			}
			// loop for one deal
			for (int i = 0; i < 7; i++) {
				LinkedList<Gamer> gamersQueue = getGamersQueue(firstGamer);
				// loop for everyone's turn
				for (int j = 0; j < 4; j++) {
					// Get next gamer from Queue
					gamer = gamersQueue.removeFirst();
					table[j] = gamer.turn(table, j);
					// Check rules
					if (j == 0) {
						if (judge.firstCardCheck(table[j], gamer)
								.getCheatCode() != CheatingType.OK) {
							gamer.pushCard(table[j]);
							j--;
						}
					} else {
						if (judge.checkTurn(table[1], table[j], gamer)
								.getCheatCode() != CheatingType.OK) {
							gamer.pushCard(table[j]);
							j--;
						}

					}
					cardGamerPairs[j] = new CardGamerPair(gamer, table[j]);
					display.printTurnCard(table[j]);
				}
				firstGamer = whoBeat(cardGamerPairs);
				if (team1.haveGamer(firstGamer)) {
					team1.addBeatCards(table);
				} else {
					team2.addBeatCards(table);
				}
				display.printText("You - " + team1.getPoints() + "/12"
						+ " Cash - " + team1.getCash() + " : Opponent - "
						+ team2.getPoints() + "/12" + " Cash - "
						+ team2.getCash());
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
			display.printText("You - " + team1.getPoints() + "/12" + " Cash - "
					+ team1.getCash() + " : Opponent - " + team2.getPoints()
					+ "/12" + " Cash - " + team2.getCash());
		} while (team1.getPoints() < 12 && team2.getPoints() < 12);
		if (team1.getPoints() >= 12) {
			display.printText("Player and Friend player - poor");
		} else {
			display.printText("Left gamer and Right gamer - poor");
		}
	}

	@Override
	public void run() {
		StartGame();

	}

}
