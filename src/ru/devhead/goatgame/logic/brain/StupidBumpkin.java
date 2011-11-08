package ru.devhead.goatgame.logic.brain;

import java.util.Iterator;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;

/**
 * Самый простой класс игрока. Ходит по правилам, но первой попавшейся картой.
 * 
 * @author kyznecov
 * 
 */
public class StupidBumpkin extends Gamer {

	// StupidBumpkin(){

	// }

	@Override
	public Card turn(Card[] table, int stepNum) {
		Iterator<Card> iterBatchOnHand;
		Card card;
		// Мы ходим первыми?
		if (stepNum == 0) {
			// Мы назначали козырь?
			if (getTrumpSetterFlag()) {
				// Ходим любой
				return batchOnHand.remove();
			} else {
				// Не назначали козыря, ходим простой картой
				for (int i = 0; i < batchOnHand.size(); i++) {
					if (!IsItTrump(batchOnHand.get(i), trump)) {
						card = batchOnHand.get(i);
						batchOnHand.remove(i);
						return card;
					}
				}
				// Обычной карты не нашли, ходим любой
				return batchOnHand.remove();
			}
		} else {
			// Первый ход был по козырю ?
			if (IsItTrump(table[0], trump)) {
				// если по козырю, тогда перебираем все карты и смотрим, есть ли
				// в колоде козырь
				iterBatchOnHand = batchOnHand.iterator();
				while (iterBatchOnHand.hasNext()) {
					// козырь нашелся?
					card = iterBatchOnHand.next();
					if (IsItTrump(card, trump)) {
						// если да,ходим ломаем цикл
						batchOnHand.remove(card);
						return card;
					}
				}
				// если козырь так и не нашли ходим первой
				return batchOnHand.remove();
			} else {
				// если не по козырю ходим в масть, если можно, если нет то
				// ходим любой(наример первой в колоде)
				iterBatchOnHand = batchOnHand.iterator();
				while (iterBatchOnHand.hasNext()) {
					// масть нашлась?
					card = iterBatchOnHand.next();
					if (suitTest(card, table[0].getSuit())) {
						// если да,ходим и ломаем цикл
						batchOnHand.remove(card);
						return card;
					}
				}
				// если масть так и не нашли ходим первой
				return batchOnHand.remove();
			}
		}
	}

	@Override
	public int assignTrump() {
		for (int i = 0; i < batchOnHand.size(); i++) {
			if (!isSuperTrump(batchOnHand.get(i))) {
				System.out.println("log - " + batchOnHand.get(i).getFace());
				setTrump(batchOnHand.get(i).getSuit());
				setTrumpSetterFlag(true);
				return batchOnHand.get(i).getSuit();
			}
		}
		setTrump(CardsNames.DIAMONDS);
		setTrumpSetterFlag(true);
		return CardsNames.DIAMONDS;
	}
}