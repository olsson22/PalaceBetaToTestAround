/**
 * @formatter:off
 */
package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Suit;

import org.junit.Test;

import static com.example.palacealpha01.GameFramework.palace.Suit.CLUBS;
import static com.example.palacealpha01.GameFramework.palace.Suit.CLUBS_INT;
import static com.example.palacealpha01.GameFramework.palace.Suit.DIAMONDS;
import static com.example.palacealpha01.GameFramework.palace.Suit.DIAMONDS_INT;
import static com.example.palacealpha01.GameFramework.palace.Suit.HEARTS;
import static com.example.palacealpha01.GameFramework.palace.Suit.HEARTS_INT;
import static com.example.palacealpha01.GameFramework.palace.Suit.SPADES;
import static com.example.palacealpha01.GameFramework.palace.Suit.SPADES_INT;
import static org.junit.Assert.*;

/**
 * @author Maximilian
 */
public class SuitTest
{

	@Test
	public void get_suit_num_test()
	{
		assertEquals(1, SPADES  .get_suit_num());
		assertEquals(2, CLUBS   .get_suit_num());
		assertEquals(3, DIAMONDS.get_suit_num());
		assertEquals(4, HEARTS  .get_suit_num());

		assertEquals(1, SPADES_INT);
		assertEquals(2, CLUBS_INT);
		assertEquals(3, DIAMONDS_INT);
		assertEquals(4, HEARTS_INT);
	}

	@Test
	public void int_to_suit_test()
	{
		assertEquals(SPADES,   Suit.int_to_suit(1));
		assertEquals(CLUBS,    Suit.int_to_suit(2));
		assertEquals(DIAMONDS, Suit.int_to_suit(3));
		assertEquals(HEARTS,   Suit.int_to_suit(4));

		assertEquals(1, SPADES_INT);
		assertEquals(2, CLUBS_INT);
		assertEquals(3, DIAMONDS_INT);
		assertEquals(4, HEARTS_INT);
	}
}