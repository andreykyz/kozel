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
	int trump = CardsNames.DIAMONDS;

	Gamer firstGamer;
	Gamer gamers[];
	int gamersCounter;

	Card[] table;

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

		table = new Card[4];
		// LinkedList

		// Создание виртуальных игроков и колоды для пользователя
		player = new ConsolePlayer(display, 0);
		leftBrain = new StupidBumpkin(1);
		friendBrain = new StupidBumpkin(2);
		rightBrain = new StupidBumpkin(3);

		gamers = new Gamer[4];
		gamers[0] = player;
		gamers[1] = leftBrain;
		gamers[2] = friendBrain;
		gamers[3] = rightBrain;

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
		//game loop
		for (int i = 0; i < 7; i++) {
			LinkedList<Gamer> gamersQueue = getGamersQueue(firstGamer);
			for (int j = 0; j < 4; j++) {
				Gamer gamer = gamersQueue.getFirst();
				if (gamer.equals(player)) {
					display.print(player.getbatchOnHand());
				}
				table[j] = gamer.turn(table, j);
				display.print(table[j]);
			}
			//whoBeat
		}

	}

	/**
	 * Устанавливает того кто ходит первый
	 * 
	 * @param gamer
	 *            - who turn first
	 */
	void setFirstGamer(Gamer gamer) {
		firstGamer = gamer;
		gamersCounter = gamer.getId();
	}

	LinkedList<Gamer> getGamersQueue(Gamer firstGamer) {
		LinkedList<Gamer> gamersQueue = new LinkedList<Gamer>();
		if (firstGamer.equals(player)) {
			gamersQueue.addLast(player);
			gamersQueue.addLast(leftBrain);
			gamersQueue.addLast(friendBrain);
			gamersQueue.addLast(rightBrain);
		} else if (firstGamer.equals(leftBrain)) {
			gamersQueue.addLast(leftBrain);
			gamersQueue.addLast(friendBrain);
			gamersQueue.addLast(rightBrain);
			gamersQueue.addLast(player);
		} else if (firstGamer.equals(friendBrain)) {
			gamersQueue.addLast(friendBrain);
			gamersQueue.addLast(rightBrain);
			gamersQueue.addLast(player);
			gamersQueue.addLast(leftBrain);
		} else if (firstGamer.equals(rightBrain)) {
			gamersQueue.addLast(rightBrain);
			gamersQueue.addLast(player);
			gamersQueue.addLast(leftBrain);
			gamersQueue.addLast(friendBrain);
		}
		return gamersQueue;
	}

	Gamer whoBeat(Card[] table) {
		for (int i = 0; i < 4; i++) {

		}
		return null;
	}

	/**
	 * Why is card bigger?
	 * 
	 * @param card1
	 * @param card2
	 * @param firstCard
	 *            - заходная карта
	 * @return
	 */
	Card cardsComparator(Card card1, Card card2, Card firstCard) {
		if (Gamer.IsItTrump(card1, trump)) {
			if (Gamer.IsItTrump(card2, trump)) {
				if (Gamer.isSuperTrump(card1)) {
					if (Gamer.isSuperTrump(card2)) {
						if (card1.getFaceId() > card2.getFaceId()) {
							return card1;
						} else {
							return card2;
						}
					} else {
						return card1;
					}
				} else {
					if (Gamer.isSuperTrump(card2)) {
						return card2;
					} else {
						if (card1.getFaceId() > card2.getFaceId()) {
							return card1;
						} else {
							return card2;
						}
					}
				}
			} else {
				return card1;
			}
		} else {
			if (card1.getSuitId() == firstCard.getSuitId()) {
				if (card2.getSuitId() == firstCard.getSuitId()) {
					if (card1.getFaceId() > card2.getFaceId()) {
						return card1;
					} else {
						return card2;
					}
				} else {
					return card1;
				}
			} else {
				// В случае, если обе карты не совпадают по масти с заходной
				return firstCard;
			}

		}
	}

}
