package ru.devhead.goatgame.logic.brain;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;
import ru.devhead.goatgame.logic.CardsNames;

public abstract class Gamer {
	CardBatch batchOnHand;
	CardBatch batchOut;
	boolean trumpSetterFlag = false;
	int trump;

	/**
	 * 
	 * @param batchOnHand
	 *            - Generated batch
	 */
	Gamer(CardBatch batchOnHand) {
		this.batchOnHand = batchOnHand;
	}

	Gamer() {
		this.batchOnHand = new CardBatch();
	}

	public void pushCard(Card card) {
		batchOnHand.add(card);
	}

	public abstract Card turn(Card[] table, int trump, int stepNum);

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

		if ((card.getSuit() == trump)
				| ((card.getFaceId() >= CardsNames.JACK_DIAMONDS) & (card
						.getFaceId() <= CardsNames.QUEEN_CROSSES))
				| (card.getFaceId() == CardsNames.SIX_CROSSES)) {
			return true;
		} else {
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

		if ((card.getSuit() == suit) & (!isSuperTrump(card))) {
			return true;
		} else {
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
		if ((card.getFaceId() == CardsNames.SIX_CROSSES)
				| (card.getPicture() == CardsNames.JACK)
				| (card.getPicture() == CardsNames.QUEEN)) {
			return true;
		} else {
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
