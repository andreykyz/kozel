package ru.devhead.goatgame.logic.brain;

import java.util.Iterator;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;

public class StupidBumpkin extends Gamer {
	
//	StupidBumpkin(){
		
//	}
	
	@Override
	public Card turn(Card[] table, int trump, int stepNum)
	{
		Iterator<Card> iterBatchOnHand;
		Card card;
		
		//Первый ход был по козырю ?
		if (IsItTrump(table[0],trump))
		{
				//если по козырю, тогда перебираем все карты и смотрим, есть ли в колоде козырь
			iterBatchOnHand = batchOnHand.iterator(); 
			  while (iterBatchOnHand.hasNext()){
				//козырь нашелся?
				card = iterBatchOnHand.next();
				if (IsItTrump(card,trump))
				{
					//если да,ходим ломаем цикл
					batchOnHand.remove(card);
					return card;
				}
			}
			//если козырь так и не нашли ходим первой
			return batchOnHand.removeFirst();
		}
		else
		{
			//если не по козырю ходим в масть, если можно, если нет то ходим любой(наример первой в колоде)
			iterBatchOnHand = batchOnHand.iterator(); 
			  while (iterBatchOnHand.hasNext()){
					//масть нашлась?
				  card = iterBatchOnHand.next();
				if (suitTest(card,table[0].getSuit()))
				{
						//если да,ходим и ломаем цикл
					batchOnHand.remove(card);
					return card;
				}
			}
			//если масть так и не нашли ходим первой

			return batchOnHand.removeFirst();
		}

}

	@Override
	public int assignTrump() {
		Card[] b = (Card[]) batchOnHand.toArray();
		for (int i = 0; i < b.length; i++) {
			if (!isSuperTrump(b[i])) {
				setTrump(b[i].getSuit());
				setTrumpSetterFlag(true);
				return b[i].getSuit();
			}
		}
		setTrump(CardsNames.DIAMONDS);
		setTrumpSetterFlag(true);
		return CardsNames.DIAMONDS;
	}
}