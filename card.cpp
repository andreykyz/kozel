#include "card.h"
#include "def.h"

Card::Card(int value)
{
	face_num = value;
	switch (value)
	{
		case SIX_CROSSES:
		{
			face = "SIX_CROSSES";
			suit = CROSSES;
			break;
		}
		case SIX_PINOCHELE:
		{
			face=  "SIX_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case SIX_HEARTS:
		{
			face = "SIX_HEARTS";
			suit = HEARTS;
			break;
		}
		case SIX_BUBI:
		{
			face = "SIX_BUBI";
			suit = BUBI;
			break;
		}
		case SEVEN_CROSSES:
		{
			face = "SEVEN_CROSSES";
			suit = CROSSES;
			break;
		}
		case SEVEN_PINOCHELE:
		{
			face = "SEVEN_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case SEVEN_HEARTS:
		{
			face = "SEVEN_HEARTS";
			suit = HEARTS;
			break;
		}
		case SEVEN_BUBI:
		{
			face = "SEVEN_BUBI";
			suit = BUBI;
			break;
		}
		case EIGHT_CROSSES:
		{
			face = "EIGHT_CROSSES";
			suit = CROSSES;
			break;
		}
		case EIGHT_PINOCHELE:
		{
			face = "EIGHT_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case EIGHT_HEARTS:
		{
			face = "EIGHT_HEARTS";
			suit = HEARTS;
			break;
		}
		case EIGHT_BUBI:
		{
			face = "EIGHT_BUBI";
			suit = BUBI;
			break;
		}
		case NINE_CROSSES:
		{
			face = "NINE_CROSSES";
			suit = CROSSES;
			break;
		}
		case NINE_PINOCHELE:
		{
			face = "NINE_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case NINE_HEARTS:
		{
			face = "NINE_HEARTS";
			suit = HEARTS;
			break;
		}
		case NINE_BUBI:
		{
			face = "NINE_BUBI";
			suit = BUBI;
			break;
		}
		case TEN_CROSSES:
		{
			face = "TEN_CROSSES";
			suit = CROSSES;
			break;
		}
		case TEN_PINOCHELE:
		{
			face = "TEN_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case TEN_HEARTS:
		{
			face = "TEN_HEARTS";
			suit = HEARTS;
			break;
		}
		case TEN_BUBI:
		{
			face = "TEN_BUBI";
			suit = BUBI;
			break;
		}
		case JACK_CROSSES:
		{
			face = "JACK_CROSSES";
			suit = CROSSES;
			break;
		}
		case JACK_PINOCHELE:
		{
			face = "JACK_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case JACK_HEARTS:
		{
			face = "JACK_HEARTS";
			suit = HEARTS;
			break;
		}
		case JACK_BUBI:
		{
			face = "JACK_BUBI";
			suit = BUBI;
			break;
		}
		case QUEEN_CROSSES:
		{
			face = "QUEEN_CROSSES";
			suit = CROSSES;
			break;
		}
		case QUEEN_PINOCHELE:
		{
			face = "QUEEN_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case QUEEN_HEARTS:
		{
			face = "QUEEN_HEARTS";
			suit = HEARTS;
			break;
		}
		case QUEEN_BUBI:
		{
			face = "QUEEN_BUBI";
			suit = BUBI;
			break;
		}
		case KING_CROSSES:
		{
			face = "KING_CROSSES";
			suit = CROSSES;
			break;
		}
		case KING_PINOCHELE:
		{
			face = "KING_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case KING_HEARTS:
		{
			face = "KING_HEARTS";
			suit = HEARTS;
			break;
		}
		case KING_BUBI:
		{
			face = "KING_BUBI";
			suit = BUBI;
			break;
		}
		case ACE_CROSSES:
		{
			face = "ACE_CROSSES";
			suit = CROSSES;
			break;
		}
		case ACE_PINOCHELE:
		{
			face = "ACE_PINOCHELE";
			suit = PINOCHELE;
			break;
		}
		case ACE_HEARTS:
		{
			face = "ACE_HEARTS";
			suit = HEARTS;
			break;
		}
		case ACE_BUBI:
		{
			face = "ACE_BUBI";
			suit = BUBI;
			break;
		}
	}
	if ((face_num>=SIX_BUBI) && (face_num<=NINE_CROSSES))
	{
		value = 0;
	}
	else if ((face_num>=TEN_BUBI) && (face_num<=TEN_CROSSES))
	{
		value = 10;
	}
	else if ((face_num>=JACK_BUBI) && (face_num<=JACK_CROSSES))
	{
		value = 2;
	}
	else if ((face_num>=QUEEN_BUBI) && (face_num<=QUEEN_CROSSES))
	{
		value = 3;
	}
	else if ((face_num>=KING_BUBI) && (face_num<=KING_CROSSES))
	{
		value = 4;
	}
	else if ((face_num>=ACE_BUBI) && (face_num<=ACE_CROSSES))
	{
		value = 11;
	}
}
