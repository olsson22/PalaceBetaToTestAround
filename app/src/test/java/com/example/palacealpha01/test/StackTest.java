/**
 * @formatter:off
 */
package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Card;
import com.example.palacealpha01.GameFramework.palace.Pair;
import com.example.palacealpha01.GameFramework.palace.Stack;

import org.junit.Test;

import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_HAND;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_LOWER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_UPPER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_HAND;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_LOWER_PALACE;import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_UPPER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.ACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.EIGHT;
import static com.example.palacealpha01.GameFramework.palace.Rank.KING;import static com.example.palacealpha01.GameFramework.palace.Rank.SEVEN;
import static com.example.palacealpha01.GameFramework.palace.Suit.CLUBS;
import static com.example.palacealpha01.GameFramework.palace.Suit.DIAMONDS;
import static com.example.palacealpha01.GameFramework.palace.Suit.SPADES;
import static org.junit.Assert.*;

/**
 * @author Maximilian
 */
public class StackTest
{
	/**
	 * The Stack.java class's push() and toString() tests rely on each other. Therefore, it is crucial
	 * for the validity of these tests, to test them simultaneously. Both tests are defined in this
	 * source file.
	 */
	@Test
	public void push()
	{
		Pair king_clubs_player_two_lower = new Pair(new Card(KING, CLUBS), PLAYER_TWO_LOWER_PALACE);
		Stack s = new Stack();
		s.push(king_clubs_player_two_lower);
		String str = "King of Clubs in Player two's lower palace\n";
		assertEquals(str, s.toString());

		Pair test_pair_one   = new Pair(new Card(ACE,   SPADES),   PLAYER_ONE_HAND);
		Pair test_pair_two   = new Pair(new Card(EIGHT, SPADES),   PLAYER_TWO_HAND);
		Pair test_pair_three = new Pair(new Card(ACE,   CLUBS),    PLAYER_ONE_UPPER_PALACE);
		Pair test_pair_four  = new Pair(new Card(EIGHT, CLUBS),    PLAYER_TWO_UPPER_PALACE);
		Pair test_pair_five  = new Pair(new Card(SEVEN, DIAMONDS), PLAYER_ONE_LOWER_PALACE);

		Stack stack = new Stack();
		String string = "";

		stack.push(test_pair_one);
		string += "Ace of Spades in Player one's hand\n";
		assertEquals(string, stack.toString());

		stack.push(test_pair_two);
		string = "Eight of Spades in Player two's hand\n" + string;
		assertEquals(string, stack.toString());

		stack.push(test_pair_three);
		string = "Ace of Clubs in Player one's upper palace\n" + string;
		assertEquals(string, stack.toString());

		stack.push(test_pair_four);
		string = "Eight of Clubs in Player two's upper palace\n" + string;
		assertEquals(string, stack.toString());

		stack.push(test_pair_five);
		string = "Seven of Diamonds in Player one's lower palace\n" + string;
		assertEquals(string, stack.toString());
	}

	@Test
	public void pop()
	{
		// TODO: write a test here
	}

	@Test
	public void peek()
	{
		// TODO: write a test here
	}

	@Test
	public void are_next_four_equal()
	{
		// TODO: write a test here
	}

	@Test
	public void is_empty()
	{
		// TODO: write a test here
	}

	@Test
	public void clear()
	{
		// TODO: write a test here
	}

	/**
	 * The Stack.java class's push() and toString() tests rely on each other. Therefore, it is crucial
	 * for the validity of these tests, to test them simultaneously. Both tests are defined in this
	 * source file.
	 */
	@Test
	public void toString_test()
	{
		// TODO: finish this test
		Pair king_clubs_player_two_lower = new Pair(new Card(KING, CLUBS), PLAYER_TWO_LOWER_PALACE);
		Stack s = new Stack();
		s.push(king_clubs_player_two_lower);
		String str = "King of Clubs in Player two's lower palace\n";
		assertEquals(str, s.toString());

		Pair test_pair_one   = new Pair(new Card(ACE,   SPADES),   PLAYER_ONE_HAND);
		Pair test_pair_two   = new Pair(new Card(EIGHT, SPADES),   PLAYER_TWO_HAND);
		Pair test_pair_three = new Pair(new Card(ACE,   CLUBS),    PLAYER_ONE_UPPER_PALACE);
		Pair test_pair_four  = new Pair(new Card(EIGHT, CLUBS),    PLAYER_TWO_UPPER_PALACE);
		Pair test_pair_five  = new Pair(new Card(SEVEN, DIAMONDS), PLAYER_ONE_LOWER_PALACE);

		Stack stack = new Stack();
		String string = "";

		stack.push(test_pair_one);
		string += "Ace of Spades in Player one's hand\n";
		assertEquals(string, stack.toString());

		stack.push(test_pair_two);
		string = "Eight of Spades in Player two's hand\n" + string;
		assertEquals(string, stack.toString());

		stack.push(test_pair_three);
		string = "Ace of Clubs in Player one's upper palace\n" + string;
		assertEquals(string, stack.toString());

		stack.push(test_pair_four);
		string = "Eight of Clubs in Player two's upper palace\n" + string;
		assertEquals(string, stack.toString());

		stack.push(test_pair_five);
		string = "Seven of Diamonds in Player one's lower palace\n" + string;
		assertEquals(string, stack.toString());
	}

	@Test
	public void equals_test()
	{
		// TODO: write a test here
	}

	@Test
	public void size()
	{
		// TODO: write a test here
	}
}