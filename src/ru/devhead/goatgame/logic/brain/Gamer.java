package ru.devhead.goatgame.logic.brain;

import org.apache.log4j.Logger;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;
import ru.devhead.goatgame.logic.CardsNames;

public abstract class Gamer {
	CardBatch batchOnHand;
	CardBatch batchOut;
	boolean trumpSetterFlag = false;
	int trump;
	int id;
	
	public int getId() {
		return id;
	}

	private static Logger logger = Logger.getLogger(Gamer.class);
		
	/**
	 * 
	 * @param batchOnHand
	 *            - Generated batch
	 */
	Gamer(CardBatch batchOnHand) {
		this.batchOnHand = batchOnHand;

	}

	Gamer(int id) {
		this.batchOnHand = new CardBatch();
		this.id = id;
	}

	public void pushCard(Card card) {
		batchOnHand.add(card);
	}

	public abstract Card turn(Card[] table, int stepNum);

	/**
	 * Is it a trump card? (Это козырь?)
	 * 
	 * @param card
	 *            - Checking card (Проверяемая карта)
	 * @param trump
	 *            - Current trump on the suit (Текущий козырь по масти)
	 * @return true Если козырь по масти либо шестерка крестей либо картинка
	 */
	public static boolean IsItTrump(Card card, int trump) {
		logger.debug("Call IsItTrump(Card card, int trump");
		logger.debug("Card = " + card.getFaceName() + "Trump = " + new Card(trump).getSuitName());

		if ((card.getSuitId() == trump) | isSuperTrump(card)) {
			logger.trace("Return true");
			return true;
		} else {
			logger.trace("Return false");
			return false;
		}
	}

	/**
	 * Проверка на масть. Масть должна совпадать и масть не 
	 * должна быть Дамой, Вальтом или шестеркой крестей(функцию нужно проверить)
	 * 
	 * @param card
	 * @param suit
	 * @return
	 */
	public static boolean suitTest(Card card, int suit) {
		logger.debug("Call suitTest(Card card, int suit");
		logger.debug("Card = " + card.getFaceName() + "Trump = " + new Card(suit).getSuitName());
		
		if ((card.getSuitId() == suit) & (!isSuperTrump(card))) {
			logger.trace("Return true");
			return true;
		} else {
			logger.trace("Return false");
			return false;			
		}
	}

	public boolean getTrumpSetterFlag() {
		return trumpSetterFlag;
	}

	public void setTrumpSetterFlag(boolean flag) {
		trumpSetterFlag = flag;
	}

	/**
	 * Возвращает true если карта Валет, Дама или шестерка крестей
	 */
	public static boolean isSuperTrump(Card card) {
		logger.debug("Call suitTest(Card card, int suit");
		logger.debug("Card = " + card.getFaceName());
		
		if ((card.getFaceId() == CardsNames.SIX_CROSSES)
				| (card.getPicture() == CardsNames.JACK)
				| (card.getPicture() == CardsNames.QUEEN)) {
			logger.trace("Return true");
			return true;
		} else {
			logger.trace("Return false");
			return false;
		}
	}

	/**
	 * Вызываем когда игрок должен назначить козырь
	 * 
	 * @return - assigned trump(назначенный козырь)
	 */

	public abstract int assignTrump();

	/**
	 * Метод назначает козырную масть для игрока
	 * 
	 * @param trump
	 *            - trump's suit(Козырная масть)
	 */
	public void setTrump(int trump) {
		this.trump = trump;
	}
	
	public CardBatch getbatchOnHand() {
		return batchOnHand;
		
	}
}
