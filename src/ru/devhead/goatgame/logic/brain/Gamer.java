package ru.devhead.goatgame.logic.brain;

import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;
import ru.devhead.goatgame.logic.CardsNames;

public abstract class Gamer {
	CardBatch batchOnHand;
	CardBatch batchOut;
	boolean trumpSetterFlag = false;
	int trump;
	int id;
	String name;
	Display display;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Gamer() {
		// stumb
	}

	public Gamer(Display display, int id) {
		this.batchOnHand = new CardBatch();
		this.id = id;
		this.display = display;
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
		if ((card.getSuitId() == trump) | isSuperTrump(card)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Проверка на масть. Масть должна совпадать и масть не 
	 * должна быть Дамой, Вальтом или шестеркой крестей
	 * 
	 * @param card
	 * @param suit
	 * @return
	 */
	public static boolean suitTest(Card card, int suit) {
		if ((card.getSuitId() == suit) & (!isSuperTrump(card))) {
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
		if ((card.getId() == CardsNames.SIX_CROSSES)
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
