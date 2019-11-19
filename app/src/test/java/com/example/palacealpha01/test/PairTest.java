/**
 * @formatter:off
 */
package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Card;
import com.example.palacealpha01.GameFramework.palace.Location;
import com.example.palacealpha01.GameFramework.palace.Pair;

import org.junit.Test;

import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_HAND;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_HAND;
import static com.example.palacealpha01.GameFramework.palace.Rank.ACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.EIGHT;
import static com.example.palacealpha01.GameFramework.palace.Suit.CLUBS;
import static com.example.palacealpha01.GameFramework.palace.Suit.SPADES;
import static org.junit.Assert.*;

/**
 * @author Maximilian
 */
public class PairTest
{
	/**
	 * The Pair.java's get_card() test relies on Card.java's equals() method. Therefore, it
	 * is crucial for the validity of this test, to test Card.java's equals() method first, which has
	 * a test written within CardTest.java, before testing Pair.java's get_card() method.
	 */
	@Test
	public void get_card()
	{
		Card test_card_one = new Card(ACE, SPADES);
		Card test_card_two = new Card(ACE, SPADES);

		assertEquals(true, test_card_one.equals(test_card_two));

		Pair test_pair = new Pair(test_card_one, PLAYER_ONE_HAND);

		assertEquals(true, test_pair.get_card().equals(test_card_two));
	}

	@Test
	public void get_location()
	{
		Pair test_pair_one = new Pair(new Card(EIGHT, CLUBS), PLAYER_TWO_HAND);
		Pair test_pair_two = new Pair(new Card(ACE, CLUBS), PLAYER_TWO_HAND);

		assertEquals(PLAYER_TWO_HAND, test_pair_one.get_location());
		assertEquals(PLAYER_TWO_HAND, test_pair_two.get_location());
	}

	@Test
	public void set_location()
	{
		Pair test_pair = new Pair(new Card(EIGHT, SPADES), PLAYER_ONE_HAND);

		assertEquals(PLAYER_ONE_HAND, test_pair.get_location());

		test_pair.set_location(PLAYER_TWO_HAND);

		assertEquals(PLAYER_TWO_HAND, test_pair.get_location());
	}

	@Test
	public void toString_test()
	{
		Pair test_pair = new Pair(new Card(ACE, SPADES), PLAYER_ONE_HAND);

		assertEquals("Ace of Spades in Player one's hand", test_pair.toString());
	}

	@Test
	public void equals_test()
	{
		Pair test_pair_one = new Pair(new Card(ACE, CLUBS), PLAYER_ONE_HAND);
		Pair test_pair_two = new Pair(new Card(ACE, CLUBS), PLAYER_ONE_HAND);

		assertEquals(true, test_pair_one.equals(test_pair_two));
	}
}