#include "massive.h"
#include "card.h"

Massive::Massive()
{
	mass_count = 0;
}

Massive::~Massive()
{
	
}

void	Massive::add(Card* item)
{
	mass[mass_count++] = item;
}

void	Massive::top_in(int z)
{
	Card*	buffer;
	for (int i = z; i <= mass_count; i++)
	{
		buffer = mass[i+1];
		mass[i+1] = mass[i];
		mass[i] = buffer;
	}
}

void	Massive::top(Card* item)
{
	for (int i = 0; i<=mass_count; i++)
	{
		if (mass[i]->zValue() == item->zValue())
		{
			top_in(i);
			break;
		}
	}
}
