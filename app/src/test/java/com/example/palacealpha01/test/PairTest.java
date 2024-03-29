/**
 * @formatter:off
 */
package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Card;
import com.example.palacealpha01.GameFramework.palace.Pair;

import org.junit.Test;

import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_HAND;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_LOWER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_UPPER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_HAND;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_LOWER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_UPPER_PALACE;import static com.example.palacealpha01.GameFramework.palace.Rank.ACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.EIGHT;
import static com.example.palacealpha01.GameFramework.palace.Rank.JACK;import static com.example.palacealpha01.GameFramework.palace.Rank.KING;import static com.example.palacealpha01.GameFramework.palace.Rank.QUEEN;import static com.example.palacealpha01.GameFramework.palace.Rank.SEVEN;import static com.example.palacealpha01.GameFramework.palace.Suit.CLUBS;
import static com.example.palacealpha01.GameFramework.palace.Suit.DIAMONDS;import static com.example.palacealpha01.GameFramework.palace.Suit.HEARTS;import static com.example.palacealpha01.GameFramework.palace.Suit.SPADES;
import static org.junit.Assert.*;

/**
 * @author Maximilian
 */
public class PairTest
{
	/**
	 * The Pair.java class's get_card() test relies on Card.java's equals() method. Therefore, it
	 * is crucial for the validity of this test, to test Card.java's equals() method first, which has
	 * a test written within CardTest.java, before testing Pair.java's get_card() method.
	 */
	@Test
	public void get_card_test()
	{
		Card king_clubs_one = new Card(KING, CLUBS);
		Card king_clubs_two = new Card(KING, CLUBS);

		assertEquals(true, king_clubs_one.equals(king_clubs_two));

		Card test_card_one   = new Card(ACE,   SPADES);
		Card test_card_two   = new Card(EIGHT, SPADES);
		Card test_card_three = new Card(ACE,   CLUBS);
		Card test_card_four  = new Card(EIGHT, CLUBS);
		Card test_card_five  = new Card(SEVEN, DIAMONDS);

		Pair test_pair_one   = new Pair(test_card_one,   PLAYER_ONE_HAND);
		Pair test_pair_two   = new Pair(test_card_two,   PLAYER_TWO_HAND);
		Pair test_pair_three = new Pair(test_card_three, PLAYER_TWO_HAND);
		Pair test_pair_four  = new Pair(test_card_four,  PLAYER_TWO_HAND);
		Pair test_pair_five  = new Pair(test_card_five,  PLAYER_TWO_HAND);

		assertEquals(true, test_pair_one  .get_card().equals(test_card_one));
		assertEquals(true, test_pair_two  .get_card().equals(test_card_two));
		assertEquals(true, test_pair_three.get_card().equals(test_card_three));
		assertEquals(true, test_pair_four .get_card().equals(test_card_four));
		assertEquals(true, test_pair_five .get_card().equals(test_card_five));
	}

	@Test
	public void get_location_test()
	{
		Pair test_pair_one   = new Pair(new Card(EIGHT, CLUBS),  PLAYER_ONE_HAND);
		Pair test_pair_two   = new Pair(new Card(ACE,   CLUBS),  PLAYER_TWO_HAND);
		Pair test_pair_three = new Pair(new Card(EIGHT, SPADES), PLAYER_ONE_LOWER_PALACE);
		Pair test_pair_four  = new Pair(new Card(ACE,   SPADES), PLAYER_TWO_LOWER_PALACE);
		Pair test_pair_five  = new Pair(new Card(KING,  HEARTS), PLAYER_ONE_UPPER_PALACE);

		assertEquals(PLAYER_ONE_HAND,         test_pair_one.  get_location());
		assertEquals(PLAYER_TWO_HAND,         test_pair_two.  get_location());
		assertEquals(PLAYER_ONE_LOWER_PALACE, test_pair_three.get_location());
		assertEquals(PLAYER_TWO_LOWER_PALACE, test_pair_four. get_location());
		assertEquals(PLAYER_ONE_UPPER_PALACE, test_pair_five. get_location());
	}

	/**
	 * The Pair.java class's set_location() test relies on Pair.java's get_location() method. Therefore,
	 * it is crucial for the validity of this test, to test Pair.java's get_location() method first,
	 * which has a test written within this source file, before testing Pair.java's get_card() method.
	 */
	@Test
	public void set_location_test()
	{
		Pair player_one_hand = new Pair(new Card(KING, CLUBS), PLAYER_ONE_HAND);

		assertEquals(PLAYER_ONE_HAND, player_one_hand.get_location());

		Pair test_pair_one   = new Pair(new Card(EIGHT, CLUBS),  PLAYER_ONE_HAND);
		Pair test_pair_two   = new Pair(new Card(ACE,   CLUBS),  PLAYER_TWO_HAND);
		Pair test_pair_three = new Pair(new Card(EIGHT, SPADES), PLAYER_ONE_LOWER_PALACE);
		Pair test_pair_four  = new Pair(new Card(ACE,   SPADES), PLAYER_TWO_LOWER_PALACE);
		Pair test_pair_five  = new Pair(new Card(KING,  HEARTS), PLAYER_ONE_UPPER_PALACE);

		assertEquals(PLAYER_ONE_HAND,         test_pair_one  .get_location());
		assertEquals(PLAYER_TWO_HAND,         test_pair_two  .get_location());
		assertEquals(PLAYER_ONE_LOWER_PALACE, test_pair_three.get_location());
		assertEquals(PLAYER_TWO_LOWER_PALACE, test_pair_four .get_location());
		assertEquals(PLAYER_ONE_UPPER_PALACE, test_pair_five .get_location());

		test_pair_one  .set_location(PLAYER_TWO_HAND);
		test_pair_two  .set_location(PLAYER_TWO_UPPER_PALACE);
		test_pair_three.set_location(PLAYER_ONE_HAND);
		test_pair_four .set_location(PLAYER_ONE_LOWER_PALACE);
		test_pair_five .set_location(PLAYER_TWO_UPPER_PALACE);

		assertEquals(PLAYER_TWO_HAND,         test_pair_one  .get_location());
		assertEquals(PLAYER_TWO_UPPER_PALACE, test_pair_two  .get_location());
		assertEquals(PLAYER_ONE_HAND,         test_pair_three.get_location());
		assertEquals(PLAYER_ONE_LOWER_PALACE, test_pair_four .get_location());
		assertEquals(PLAYER_TWO_UPPER_PALACE, test_pair_five .get_location());
	}

	@Test
	public void getX_test()
	{
		// TODO: write a test here
	}

	@Test
	public void getY_test()
	{
		// TODO: write a test here
	}

	@Test
	public void setX_test()
	{
		// TODO: write a test here
	}

	@Test
	public void setY_test()
	{
		// TODO: write a test here
	}

	@Test
	public void toString_test()
	{
		Pair test_pair_one   = new Pair(new Card(ACE,   SPADES),   PLAYER_ONE_HAND);
		Pair test_pair_two   = new Pair(new Card(EIGHT, SPADES),   PLAYER_TWO_HAND);
		Pair test_pair_three = new Pair(new Card(ACE,   CLUBS),    PLAYER_ONE_UPPER_PALACE);
		Pair test_pair_four  = new Pair(new Card(EIGHT, CLUBS),    PLAYER_TWO_UPPER_PALACE);
		Pair test_pair_five  = new Pair(new Card(JACK,  DIAMONDS), PLAYER_ONE_LOWER_PALACE);

		assertEquals("Ace of Spades in Player one's hand",            test_pair_one  .toString());
		assertEquals("Eight of Spades in Player two's hand",          test_pair_two  .toString());
		assertEquals("Ace of Clubs in Player one's upper palace",     test_pair_three.toString());
		assertEquals("Eight of Clubs in Player two's upper palace",   test_pair_four .toString());
		assertEquals("Jack of Diamonds in Player one's lower palace", test_pair_five .toString());
	}

	@Test
	public void equals_test()
	{
		Pair test_pair_one_a   = new Pair(new Card(ACE,   CLUBS),  PLAYER_ONE_HAND);
		Pair test_pair_one_b   = new Pair(new Card(ACE,   CLUBS),  PLAYER_ONE_HAND);
		Pair test_pair_two_a   = new Pair(new Card(ACE,   SPADES), PLAYER_ONE_HAND);
		Pair test_pair_two_b   = new Pair(new Card(ACE,   SPADES), PLAYER_ONE_HAND);
		Pair test_pair_three_a = new Pair(new Card(EIGHT, CLUBS),  PLAYER_ONE_LOWER_PALACE);
		Pair test_pair_three_b = new Pair(new Card(EIGHT, CLUBS),  PLAYER_ONE_LOWER_PALACE);
		Pair test_pair_four_a  = new Pair(new Card(EIGHT, CLUBS),  PLAYER_TWO_LOWER_PALACE);
		Pair test_pair_four_b  = new Pair(new Card(EIGHT, CLUBS),  PLAYER_TWO_LOWER_PALACE);
		Pair test_pair_five_a  = new Pair(new Card(ACE,   CLUBS),  PLAYER_TWO_HAND);
		Pair test_pair_five_b  = new Pair(new Card(ACE,   CLUBS),  PLAYER_TWO_HAND);

		assertEquals(true,  test_pair_one_a  .equals(test_pair_one_b));
		assertEquals(true,  test_pair_two_a  .equals(test_pair_two_b));
		assertEquals(true,  test_pair_three_a.equals(test_pair_three_b));
		assertEquals(true,  test_pair_four_a .equals(test_pair_four_b));
		assertEquals(true,  test_pair_five_a .equals(test_pair_five_b));
		assertEquals(false, test_pair_one_a  .equals(test_pair_five_a));
		assertEquals(false, test_pair_one_a  .equals(test_pair_two_a));
	}
}