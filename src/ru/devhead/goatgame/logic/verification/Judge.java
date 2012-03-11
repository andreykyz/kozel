package ru.devhead.goatgame.logic.verification;

import java.util.Iterator;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.brain.Gamer;
import ru.devhead.goatgame.logic.brain.GamersTeam;

/**
 * class for check rule
 * 
 * @author kyznecov
 * 
 */
public class Judge {

	Card trump;
	GamersTeam trumpSetter;
	GamersTeam otherTeam;

	public Judge(Card trump, GamersTeam trumpSetter) {
		this.trump = trump;
		this.trumpSetter = trumpSetter;
	}

	// WARNING должно работыть правильно, но нужно протестировать
	public CheatingType checkTurn(Card firstCard, Card turnCard, Gamer gamer) {
		Iterator<Card> iterBatchOnHand;
		// 1 Если первый ход был по козырю
		if (Gamer.IsItTrump(firstCard, trump.getSuitId())) {
			// if first card is trump
			// Если первый ход по козырю
			if (!Gamer.IsItTrump(turnCard, trump.getSuitId())) {
				// and gamer turned card isn't trump
				// и игрок пошел не козырем, то
				iterBatchOnHand = gamer.getbatchOnHand().iterator();
				while (iterBatchOnHand.hasNext()) {
					// gamer can't have other simple cards identical firstCard
					// in his batch
					// у игрока не должно быть козырей
					if (Gamer.IsItTrump(firstCard, iterBatchOnHand.next().getSuitId())) {
						// if found trump then return error
						// Если находим козырь, возвращаем ошибку
						return new CheatingType(CheatingType.TRUMP_CHEAT_CODE);
					}
				}
			}
			// if first card isn't trump
			// 2 Если первый ход был не по козырю
		} else {
			if (Gamer.IsItTrump(turnCard, trump.getSuitId())) {
				// and gamer turned trump
				// и игрок пошел по козырю
				iterBatchOnHand = gamer.getbatchOnHand().iterator();
				while (iterBatchOnHand.hasNext()) {
					// gamer can't have card's suit equal turnCard in his batch
					// у игрока не может быть карты совпадающей по масти с заходной
					if(Gamer.suitTest(iterBatchOnHand.next(), firstCard.getSuitId())) {
						//If he have this card, return error
						//Если у него есть такая карта, то ошибка
						return new CheatingType(CheatingType.SUIT_CHEAT_CODE);
					}
				}
			} else {
				if (Gamer.suitTest(firstCard, turnCard.getSuitId())) {
					// gamer turned card with suit equal firstCard's suit
					// игрок пошел картой с мастью как у заходной карты
					return new CheatingType(CheatingType.OK);
				} else {
					// gamer turned card with anoter suit
					// игрок пошел картой с мастью отличной от заходной
					iterBatchOnHand = gamer.getbatchOnHand().iterator();
					while (iterBatchOnHand.hasNext()) {
						// если у него найдется карта с мастю как у заходной, то ошибка
						if(Gamer.suitTest(iterBatchOnHand.next(), firstCard.getFaceId())){
							return new CheatingType(CheatingType.SUIT_CHEAT_CODE);
						}

					}
				}
			}
			
		}

		return new CheatingType(CheatingType.OK);

	}
	
	public CheatingType firstCardCheck(Card firstCard, Gamer gamer) {
		Iterator<Card> iterBatchOnHand;
		//Если игрок пошёл по козырю
		if (Gamer.IsItTrump(firstCard, trump.getSuitId())) {
			// И если не его команда назнаячала козырь
			if (!gamer.getTrumpSetterFlag()) {
				iterBatchOnHand = gamer.getbatchOnHand().iterator();
				while(iterBatchOnHand.hasNext()) {
					// У него не может быть обычных карт(не козырей)
					if (!Gamer.IsItTrump(firstCard, trump.getSuitId())){
						//т.е. Если у него есть обычная карта, то ошибка
						return new CheatingType(CheatingType.FIRST_TURN_CHEAT_CODE);
					}
				}

			}
		}
		return  new CheatingType(CheatingType.OK);
	}

	/**
	 * Method is checkTurn's throw exception analog
	 * 
	 * @param turnCard
	 * @param gamer
	 */
	public void checkTurn(Card turnCard, Gamer gamer) {

	}

}
