#include "board.h"
#include "def.h"
#include "card.h"
//#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <list>
Board::Board()
{
	time_t now;
	time(&now);
	//В качестве затравки для генератора случайных чисел берем время
	srand((localtime(&now)->tm_sec)+(localtime(&now)->tm_min*60));
	std::cout << (localtime(&now)->tm_sec)+(localtime(&now)->tm_min*60) << '\n';
	bool	dim[28];
	int col[28];
	int j;
	for (int i=0;i<28;i++)
	{
		dim[i]=false;
	}
	//Замешиваем колоду
	for (int i=0;i<28;i++)
	{
//		printf("\n");
		do
		{
			j = (rand()%28);
//			printf("%u(%i) ",j,dim[j]);
		}
		while(dim[j]);
		dim[j]=true;
		col[i] = j;
//		printf("\n%i",j);
	}
//	printf("\n");
	//Раздаём
	for (int i=0;i<7;i++)
	{
		human.push_front(new Card(col[i]));
		x2.push_front(new Card(col[i+7]));
		y2.push_front(new Card(col[i+14]));
		y1.push_front(new Card(col[i+21]));
	}
}

void	Board::run()
{
	//Пока козырь всегда буби
	Card* table[4];
	int trump = BUBI;
	for(int i =0;i<7;i++)
	{
		int d = 0;
		//Ход ползователя
		std::cout << "\n";
		//Выводим оставшиеся карты на экран
		for (std::list<Card*>::iterator i = human.begin(); i != human.end(); i++)
		{
			std::cout << d++ << " : "<< (*i)->face << '\n';
		}
		std::cout << "Какой картой будем ходить?\n";
		//Какой картой будем ходить?
		std::cin >> d;
		std::list<Card*>::iterator iter = human.begin();
		for (int i=0;i<d;i++) iter++;
		std::cout << d << " : "<< (*iter)->face << '\n';
		table[1] = *iter;
		human.erase(iter);
		if(trump_it(table[1],trump))
		{
			std::cout << "ход по козырю\n";
		}
		else 
		{
			std::cout << "ход не по козырю\n";
		}
		//Ход компьютера (первый противник)
/*		d = 0;
		for (std::list<Card*>::iterator i = y1.begin(); i != y1.end(); i++)
		{
			std::cout << d++ << " : "<< (*i)->face << '\n';
		}*/
		table[2] = brain(&y1,table,trump,2);
		//Ход компьютера (аппонет противник)
		table[3] = brain(&x2,table,trump,3);
		//Ход компьютера (второй противник)
		table[4] = brain(&y2,table,trump,4);
		std::cout << table[1]->face << "\t"<< table[2]->face << '\n' << table[4]->face << "\t"<< table[3]->face <<'\n';
	}
	
}
//Проверка карты на козырь
bool	Board::trump_it(Card* card, int trump)
{
	//козыть по масти либо шестерка крестей либо картинка
	if ((card->suit==trump) || ((card->face_num>=JACK_BUBI) && (card->face_num<=QUEEN_CROSSES)) || (card->face_num==SIX_CROSSES))
	{
		return true;
	}
	else
	{
		return false;
	}
}
//Проверка на масть(функция пока неправильная)
bool	Board::in_suit(Card* card, int suit)
{
		//масть должна совпадать и масть не должна быть картинкой или шестеркой крестей
	if ((card->suit==suit) && (((card->face_num>=SIX_BUBI) && (card->face_num<=TEN_CROSSES)) || ((card->face_num>=ACE_BUBI) && (card->face_num<=ACE_CROSSES))) && (card->face_num!=SIX_CROSSES))
	{
		return true;
	}
	else
	{
		return false;
	}
}
//Функция искуственного интелекта игры в козла
Card*	Board::brain(std::list<Card*>* cold,Card* table[4],int trump,int step_num)
{
	Card* buff;
	//Первый ход был по козырю ?
	if (trump_it(table[1],trump))
	{
			//если по козырю, тогда перебираем все карты и смотрим, есть ли в колоде козырь
		for (std::list<Card*>::iterator i = (*cold).begin(); i != (*cold).end(); i++)
		{
				//козырь нашелся?
			if (trump_it(*i,trump))
			{
					//если да,ходим ломаем цикл
				buff = *i;
				(*cold).erase(i);
				return buff;
			}
		}
		//если козырь так и не нашли ходим любой(наример на которую указавет итератор)
		buff = *((*cold).begin());
		(*cold).erase((*cold).begin());
		return buff;
	}
	else
	{
		//усли не по козырю ходим в масть, если можно, если нет то ходим любой(наример первой в колоде)
		for (std::list<Card*>::iterator i = (*cold).begin(); i != (*cold).end(); i++)
		{
				//масть нашлась?
			if (in_suit(*i,table[1]->suit))
			{
					//если да,ходим и ломаем цикл
				buff = *i;
				(*cold).erase(i);
				return buff;
			}
		}
		//если масть так и не нашли ходим любой(наример на которую указавет итератор)
		buff = *((*cold).begin());
		(*cold).erase((*cold).begin());
		return buff;
	}
}
