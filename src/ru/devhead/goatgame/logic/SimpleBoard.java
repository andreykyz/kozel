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

	private CardBatch batchForGame;

	public SimpleBoard(Display display) {
		super(display);
		
		// Making virtual gamers and ...
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
		
		batchForGame = getMixBatch();
		table = new Card[4];
		cardGamerPairs = new CardGamerPair[4];

		playerTeam = new GamersTeam(player, friendBrain);
		computerTeam = new GamersTeam(leftBrain, rightBrain);
		
		// First batch deal
		trumpSetterGamer = dealCardBatch(batchForGame);
		trump = trumpSetterGamer.assignTrump();
		setFirstTurnGamer(trumpSetterGamer);
		if (playerTeam.haveGamer(trumpSetterGamer)) {
			playerTeam.getGamer1().setTrumpSetterFlag(true);
			playerTeam.getGamer2().setTrumpSetterFlag(true);
			computerTeam.getGamer1().setTrumpSetterFlag(false);
			computerTeam.getGamer2().setTrumpSetterFlag(false);
		} else {
			playerTeam.getGamer1().setTrumpSetterFlag(false);
			playerTeam.getGamer2().setTrumpSetterFlag(false);
			computerTeam.getGamer1().setTrumpSetterFlag(true);
			computerTeam.getGamer2().setTrumpSetterFlag(true);
		}
		player.setTrump(trump);
		leftBrain.setTrump(trump);
		friendBrain.setTrump(trump);
		rightBrain.setTrump(trump);
		
	}

	private void StartGame() {

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
			if (playerTeam.getGamer1().getTrumpSetterFlag()) {
				judge = new Judge(new Card(trump), playerTeam);
			} else {
				judge = new Judge(new Card(trump), computerTeam);
			}
			// loop for one deal
			for (int i = 0; i < 7; i++) {
				LinkedList<Gamer> gamersQueue = getGamersQueue(firstTurnGamer);
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
				firstTurnGamer = whoBeat(cardGamerPairs);
				if (playerTeam.haveGamer(firstTurnGamer)) {
					playerTeam.addBeatCards(table);
				} else {
					computerTeam.addBeatCards(table);
				}
				display.printText("You - " + playerTeam.getPoints() + "/12"
						+ " Cash - " + playerTeam.getCash() + " : Opponent - "
						+ computerTeam.getPoints() + "/12" + " Cash - "
						+ computerTeam.getCash());
			}
			tempPoints = 0;
			if (playerTeam.getCash() < 60) {
				tempPoints = 2;
				if (playerTeam.getCash() < 60) {
					tempPoints = 4;
					if (playerTeam.getCash() == 0) {
						tempPoints = 6;
					}
				}
				if (dublePoint) {
					dublePoint = false;
					tempPoints = tempPoints * 2;
				}
				playerTeam.addPoints(tempPoints);
			} else if (computerTeam.getCash() < 60) {
				tempPoints = 2;
				if (computerTeam.getCash() < 60) {
					tempPoints = 4;
					if (computerTeam.getCash() == 0) {
						tempPoints = 6;
					}
				}
				if (dublePoint) {
					dublePoint = false;
					tempPoints = tempPoints * 2;
				}
				computerTeam.addPoints(tempPoints);
			}
			
			trumpSetterGamer = getNextTrumpSetter(trumpSetterGamer);
			setFirstTurnGamer(trumpSetterGamer);

			batchForGame = getMixBatch();
			trump = dealCardBatch(batchForGame, trumpSetterGamer);
			player.setTrump(trump);
			leftBrain.setTrump(trump);
			friendBrain.setTrump(trump);
			rightBrain.setTrump(trump);
			
			if (playerTeam.getCash() == 60) {
				// Next Points doubling
				dublePoint = true;
			}
			display.printText("You - " + playerTeam.getPoints() + "/12" + " Cash - "
					+ playerTeam.getCash() + " : Opponent - " + computerTeam.getPoints()
					+ "/12" + " Cash - " + computerTeam.getCash());
		} while (playerTeam.getPoints() < 12 && computerTeam.getPoints() < 12);
		if (playerTeam.getPoints() >= 12) {
			display.printText("Player and Friend player - poor");
		} else {
			display.printText("Left gamer and Right gamer - poor");
		}
	}

	@Override
	public void run() {
		StartGame();

	}

	@Override
	CardBatch getMixBatch() {
		CardBatch batchForGame = new CardBatch();
		for (int i = 0; i < CardBatch.kozelBatch.length; i++) {
			batchForGame.add(new CardWrapper(i));
		}
		batchForGame.mixCardBatch();
		return batchForGame;
	}
	
	

}
