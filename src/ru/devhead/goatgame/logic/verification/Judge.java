package ru.devhead.goatgame.logic.verification;

import java.util.Iterator;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.brain.Gamer;
import ru.devhead.goatgame.logic.brain.GamersTeam;

/**
 * class for check rule
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
	
	//WARNING Работает не правильно, нужно проверить
	public CheatingType checkTurn(Card firstCard, Card turnCard, Gamer gamer) {
		Iterator<Card> iterBatchOnHand;
		if (Gamer.IsItTrump(firstCard, trump.getSuitId())) {
			// if first card is trump
			if (!Gamer.IsItTrump(turnCard, trump.getSuitId())) {
				// and gamer turned card isn't trump
				iterBatchOnHand = gamer.getbatchOnHand().iterator();
				while (iterBatchOnHand.hasNext()) {
					// gamer can't have other simple cards identical firstCard in his batch
					if (Gamer.IsItTrump(firstCard, iterBatchOnHand.next().getSuitId())) {
						return new CheatingType(CheatingType.TRUMP_CHEAT_CODE);
					}
				}
			}
		} else if(!gamer.equals(trumpSetter)){
			//if first card isn't trump and gamer isn't trump setter
			if (Gamer.IsItTrump(turnCard, trump.getSuitId())) {
			// and gamer turned trump
				iterBatchOnHand = gamer.getbatchOnHand().iterator();
				while (iterBatchOnHand.hasNext()) {
					// gamer can't have other trump in his batch
				}
			}
		}
			
		return new CheatingType(CheatingType.OK);
		
	}
	
	/**
	 * Method is checkTurn's throw exception analog 
	 * 
	 * @param turnCard
	 * @param gamer
	 */
	public void checkTurnTE(Card turnCard, Gamer gamer) {
		
	}
	
	

}
