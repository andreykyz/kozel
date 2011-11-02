#include <string.h>
class Card
{
public:
	Card(int);
	~Card();
	int	face_num;
	int	suit;
	int	value;
	char*	face;
};
