package ru.devhead.goatgame.logic.brain;

import java.util.Iterator;

import org.apache.log4j.Logger;

import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;

/**
 * Самый простой класс игрока. Ходит по правилам, но первой попавшейся картой.
 * 
 * @author kyznecov
 * 
 */
public class StupidBumpkin extends Gamer {

	private static Logger logger = Logger.getLogger(Gamer.class);

	public StupidBumpkin(Display display, int id) {
		super(display, id);
	}

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
					if (suitTest(card, table[0].getSuitId())) {
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
		logger.debug("assignTrump()");
		for (int i = 0; i < batchOnHand.size(); i++) {
			if (!isSuperTrump(batchOnHand.get(i))) {
				logger.debug(batchOnHand.get(i).getName());
				
				setTrump(batchOnHand.get(i).getSuitId());
				setTrumpSetterFlag(true);
				logger.trace("return " + batchOnHand.get(i).getSuitName());
				return batchOnHand.get(i).getSuitId();
			}
		}
		setTrump(CardsNames.DIAMONDS);
		setTrumpSetterFlag(true);
		logger.trace("return DIAMOND");
		return CardsNames.DIAMONDS;
	}
}
