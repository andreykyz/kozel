//#include "card.h"
class Card;

class Massive  
{

private:
	int	mass_count;
//	Card*	mass[36];
	void	top_in(int);
public:
	Massive();
	Card*	mass[36];
	void	add(Card*);
	void	top(Card*);
	~Massive();
};
