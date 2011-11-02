#include <list>
//#include <vector>
class Card;
//class list;

class Board
{
//	void	mix(int *);
	bool	trump_it(Card*,int);
	bool	in_suit(Card*,int);
	bool	in_suit(Card*, Card*);
	Card*	brain(std::list<Card*>*, Card* [4],int,int);
	std::list<Card*> human;
	std::list<Card*> x2;
	std::list<Card*> y1;
	std::list<Card*> y2;
public:
	Board();
	~Board() {}
	void	run();
};
