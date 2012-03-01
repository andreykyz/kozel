package ru.devhead.goatgame.logic;

import java.util.LinkedList;

import ru.devhead.goatgame.display.Console;
import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.brain.Player;
import ru.devhead.goatgame.logic.brain.Gamer;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

/**
 * @author kyznecov
 * 
 */
public class Board {

	/**
	 * @param args
	 */

	int stepNum = 0;
	int trump = CardsNames.DIAMONDS;
	boolean dublePoint = false;
	int tempPoints = 0;

	Gamer firstGamer;
	Gamer gamers[];
	int gamersCounter;

	Card[] table;
	CardGamerPair[] cardGamerPairs;

	Gamer player;
	Gamer leftBrain;
	Gamer friendBrain;
	Gamer rightBrain;
	GamersTeam team1;
	GamersTeam team2;

	public Board() {

		Display display = new Console();
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

	/**
	 * Устанавливает того кто ходит первый
	 * 
	 * @param gamer
	 *            - who turn first
	 */
	private void setFirstGamer(Gamer gamer) {
		firstGamer = gamer;
		gamersCounter = gamer.getId();
	}

	/**
	 * 
	 * @param firstGamer
	 *            - that who will be at the top of LinkedList
	 * @return
	 */
	private LinkedList<Gamer> getGamersQueue(Gamer firstGamer) {
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

	private Gamer whoBeat(CardGamerPair[] cgPairs) {
		Card vinCard = cgPairs[0].getCard();
		for (int i = 1; i < 4; i++) {
			vinCard = cardsComparator(vinCard, cgPairs[i].getCard(),
					cgPairs[0].getCard());
		}
		Gamer vinGamer = null;
		for (int i = 0; i < 4; i++) {
			if (cgPairs[i].getCard().equals(vinCard)) {
				vinGamer = cgPairs[i].getGamer();
			}
		}
		return vinGamer;
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
	private Card cardsComparator(Card card1, Card card2, Card firstCard) {
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

	/**
	 * 
	 * @author kyznecov
	 * 
	 */
	private class CardGamerPair {

		private Gamer gamer;
		private Card card;

		public CardGamerPair(Gamer gamer, Card card) {
			this.gamer = gamer;
			this.card = card;
		}

		public Gamer getGamer() {
			return gamer;
		}

		public Card getCard() {
			return card;
		}

	}

}
