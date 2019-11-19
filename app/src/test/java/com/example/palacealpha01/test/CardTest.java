/**
 * @formatter:off
 */
package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Card;

import org.junit.Test;

import static com.example.palacealpha01.GameFramework.palace.Rank.ACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.EIGHT;
import static com.example.palacealpha01.GameFramework.palace.Rank.JACK;
import static com.example.palacealpha01.GameFramework.palace.Rank.KING;
import static com.example.palacealpha01.GameFramework.palace.Rank.QUEEN;
import static com.example.palacealpha01.GameFramework.palace.Rank.SEVEN;
import static com.example.palacealpha01.GameFramework.palace.Rank.TEN;
import static com.example.palacealpha01.GameFramework.palace.Rank.THREE;
import static com.example.palacealpha01.GameFramework.palace.Rank.TWO;
import static com.example.palacealpha01.GameFramework.palace.Suit.CLUBS;
import static com.example.palacealpha01.GameFramework.palace.Suit.DIAMONDS;
import static com.example.palacealpha01.GameFramework.palace.Suit.HEARTS;
import static com.example.palacealpha01.GameFramework.palace.Suit.SPADES;
import static org.junit.Assert.*;

/**
 * @author Maximilian
 */
public class CardTest
{
	/**
	 * The Card.java's copy_constructor() test relies on Card.java's equals() method. Therefore, it
	 * is crucial for the validity of this test, to test Card.java's equals() method first, which has
	 * a test written within this source file, before testing Card.java's copy constructor.
	 */
	@Test
	public void copy_constructor()
	{
		Card king_clubs_one = new Card(KING, CLUBS);
		Card king_clubs_two = new Card(KING, CLUBS);

		assertEquals(true, king_clubs_one.equals(king_clubs_two));

		Card ace_spades = new Card(ACE, SPADES);
		Card ace_clubs = new Card(ACE, CLUBS);
		Card eight_clubs = new Card(EIGHT, CLUBS);
		Card eight_spades = new Card(EIGHT, SPADES);

		Card three_clubs = new Card(THREE, CLUBS);
		Card seven_diamonds = new Card(SEVEN, DIAMONDS);
		Card jack_spades = new Card(JACK, SPADES);
		Card queen_hearts = new Card(QUEEN, HEARTS);
		Card two_hearts = new Card(TWO, HEARTS);
		Card ten_diamonds = new Card(TEN, DIAMONDS);



		Card ace_spades_copy = new Card(ace_spades);
		Card ace_clubs_copy = new Card(ace_clubs);
		Card eight_clubs_copy = new Card(eight_clubs);
		Card eight_spades_copy = new Card(eight_spades);

		Card three_clubs_copy = new Card(three_clubs);
		Card seven_diamonds_copy = new Card(seven_diamonds);
		Card jack_spades_copy = new Card(jack_spades);
		Card queen_hearts_copy = new Card(queen_hearts);
		Card two_hearts_copy = new Card(two_hearts);
		Card ten_diamonds_copy = new Card(ten_diamonds);



		assertEquals(true, ace_spades.equals(ace_spades_copy));
		assertEquals(true, ace_clubs.equals(ace_clubs_copy));
		assertEquals(true, eight_spades.equals(eight_spades_copy));
		assertEquals(true, eight_clubs.equals(eight_clubs_copy));

		assertEquals(true, three_clubs.equals(three_clubs_copy));
		assertEquals(true, seven_diamonds.equals(seven_diamonds_copy));
		assertEquals(true, jack_spades.equals(jack_spades_copy));
		assertEquals(true, queen_hearts.equals(queen_hearts_copy));
		assertEquals(true, two_hearts.equals(two_hearts_copy));
		assertEquals(true, ten_diamonds.equals(ten_diamonds_copy));
	}

	@Test
	public void get_rank()
	{
		Card ace_spades = new Card(ACE, SPADES);
		Card ace_clubs = new Card(ACE, CLUBS);
		Card eight_clubs = new Card(EIGHT, CLUBS);
		Card eight_spades = new Card(EIGHT, SPADES);

		Card three_clubs = new Card(THREE, CLUBS);
		Card seven_diamonds = new Card(SEVEN, DIAMONDS);
		Card jack_spades = new Card(JACK, SPADES);
		Card queen_hearts = new Card(QUEEN, HEARTS);
		Card two_hearts = new Card(TWO, HEARTS);
		Card ten_diamonds = new Card(TEN, DIAMONDS);



		assertEquals(ACE, ace_spades.get_rank());
		assertEquals(ACE, ace_clubs.get_rank());
		assertEquals(EIGHT, eight_clubs.get_rank());
		assertEquals(EIGHT, eight_spades.get_rank());

		assertEquals(THREE, three_clubs.get_rank());
		assertEquals(SEVEN, seven_diamonds.get_rank());
		assertEquals(JACK, jack_spades.get_rank());
		assertEquals(QUEEN, queen_hearts.get_rank());
		assertEquals(TWO, two_hearts.get_rank());
		assertEquals(TEN, ten_diamonds.get_rank());
	}

	@Test
	public void toString_test()
	{
		Card ace_spades = new Card(ACE, SPADES);
		Card ace_clubs = new Card(ACE, CLUBS);
		Card eight_clubs = new Card(EIGHT, CLUBS);
		Card eight_spades = new Card(EIGHT, SPADES);

		Card three_clubs = new Card(THREE, CLUBS);
		Card seven_diamonds = new Card(SEVEN, DIAMONDS);
		Card jack_spades = new Card(JACK, SPADES);
		Card queen_hearts = new Card(QUEEN, HEARTS);
		Card two_hearts = new Card(TWO, HEARTS);
		Card ten_diamonds = new Card(TEN, DIAMONDS);



		assertEquals("Ace of Spades", ace_spades.toString());
		assertEquals("Ace of Clubs", ace_clubs.toString());
		assertEquals("Eight of Clubs", eight_clubs.toString());
		assertEquals("Eight of Spades", eight_spades.toString());

		assertEquals("Three of Clubs", three_clubs.toString());
		assertEquals("Seven of Diamonds", seven_diamonds.toString());
		assertEquals("Jack of Spades", jack_spades.toString());
		assertEquals("Queen of Hearts", queen_hearts.toString());
		assertEquals("Two of Hearts", two_hearts.toString());
		assertEquals("Ten of Diamonds", ten_diamonds.toString());
	}

	@Test
	public void equals_test()
	{
		Card ace_spades = new Card(ACE, SPADES);
		Card ace_clubs = new Card(ACE, CLUBS);
		Card eight_clubs = new Card(EIGHT, CLUBS);
		Card eight_spades = new Card(EIGHT, SPADES);

		Card three_clubs = new Card(THREE, CLUBS);
		Card seven_diamonds = new Card(SEVEN, DIAMONDS);
		Card jack_spades = new Card(JACK, SPADES);
		Card queen_hearts = new Card(QUEEN, HEARTS);
		Card two_hearts = new Card(TWO, HEARTS);
		Card ten_diamonds = new Card(TEN, DIAMONDS);



		Card ace_spades_copy = new Card(ACE, SPADES);
		Card ace_clubs_copy = new Card(ACE, CLUBS);
		Card eight_clubs_copy = new Card(EIGHT, CLUBS);
		Card eight_spades_copy = new Card(EIGHT, SPADES);

		Card three_clubs_copy = new Card(THREE, CLUBS);
		Card seven_diamonds_copy = new Card(SEVEN, DIAMONDS);
		Card jack_spades_copy = new Card(JACK, SPADES);
		Card queen_hearts_copy = new Card(QUEEN, HEARTS);
		Card two_hearts_copy = new Card(TWO, HEARTS);
		Card ten_diamonds_copy = new Card(TEN, DIAMONDS);



		assertEquals(true, ace_spades.equals(ace_spades_copy));
		assertEquals(true, ace_clubs.equals(ace_clubs_copy));
		assertEquals(true, eight_spades.equals(eight_spades_copy));
		assertEquals(true, eight_clubs.equals(eight_clubs_copy));

		assertEquals(true, three_clubs.equals(three_clubs_copy));
		assertEquals(true, seven_diamonds.equals(seven_diamonds_copy));
		assertEquals(true, jack_spades.equals(jack_spades_copy));
		assertEquals(true, queen_hearts.equals(queen_hearts_copy));
		assertEquals(true, two_hearts.equals(two_hearts_copy));
		assertEquals(true, ten_diamonds.equals(ten_diamonds_copy));
	}
}