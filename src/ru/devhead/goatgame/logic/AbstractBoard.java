package ru.devhead.goatgame.logic;

import java.util.LinkedList;

import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.brain.Player;
import ru.devhead.goatgame.logic.brain.Gamer;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

/**
 * @author kyznecov
 * 
 */
public abstract class AbstractBoard  {

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
	
	Display display;

	public AbstractBoard(Display display) {
		this.display = display;
	}



	/**
	 * Устанавливает того кто ходит первый
	 * 
	 * @param gamer
	 *            - who turn first
	 */
	protected void setFirstGamer(Gamer gamer) {
		firstGamer = gamer;
		gamersCounter = gamer.getId();
	}

	/**
	 * 
	 * @param firstGamer
	 *            - that who will be at the top of LinkedList
	 * @return
	 */
	protected LinkedList<Gamer> getGamersQueue(Gamer firstGamer) {
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

	protected Gamer whoBeat(CardGamerPair[] cgPairs) {
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
	protected Card cardsComparator(Card card1, Card card2, Card firstCard) {
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
	protected class CardGamerPair {

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
