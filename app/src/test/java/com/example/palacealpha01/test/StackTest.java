/**
 * @formatter:off
 */
package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Card;
import com.example.palacealpha01.GameFramework.palace.Pair;
import com.example.palacealpha01.GameFramework.palace.Stack;

import org.junit.Test;

import java.util.Random;

import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_HAND;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_LOWER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_UPPER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_HAND;
import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_LOWER_PALACE;import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_TWO_UPPER_PALACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.ACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.EIGHT;
import static com.example.palacealpha01.GameFramework.palace.Rank.FIVE;import static com.example.palacealpha01.GameFramework.palace.Rank.FOUR;import static com.example.palacealpha01.GameFramework.palace.Rank.JACK;import static com.example.palacealpha01.GameFramework.palace.Rank.KING;import static com.example.palacealpha01.GameFramework.palace.Rank.NINE;import static com.example.palacealpha01.GameFramework.palace.Rank.SEVEN;
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
	public void push_test()
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

	/**
	 * The Stack.java class's pop() method test relies on Stack.java's toString() method. Therefore,
	 * it is crucial for the validity of this test to test Stack.java's toString() method first, which
	 * is defined within this source file, before testing Stack.java's pop() method.
	 */
	@Test
	public void pop_test()
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
		Pair[] pairs = {test_pair_one, test_pair_two, test_pair_three, test_pair_four, test_pair_five};

		Stack stack = new Stack(pairs, false);
		String string =	"Ace of Spades in Player one's hand\n" +
						"Eight of Spades in Player two's hand\n" +
						"Ace of Clubs in Player one's upper palace\n" +
						"Eight of Clubs in Player two's upper palace\n" +
						"Seven of Diamonds in Player one's lower palace\n";
		assertEquals(string, stack.toString());

		Pair pair = stack.pop();
		string =	"Eight of Spades in Player two's hand\n" +
					"Ace of Clubs in Player one's upper palace\n" +
					"Eight of Clubs in Player two's upper palace\n" +
					"Seven of Diamonds in Player one's lower palace\n";
		assertEquals(true, pair.equals(test_pair_one));
		assertEquals(string, stack.toString());

		pair = stack.pop();
		string =	"Ace of Clubs in Player one's upper palace\n" +
					"Eight of Clubs in Player two's upper palace\n" +
					"Seven of Diamonds in Player one's lower palace\n";
		assertEquals(true, pair.equals(test_pair_two));
		assertEquals(string, stack.toString());

		pair = stack.pop();
		string =	"Eight of Clubs in Player two's upper palace\n" +
					"Seven of Diamonds in Player one's lower palace\n";
		assertEquals(true, pair.equals(test_pair_three));
		assertEquals(string, stack.toString());

		pair = stack.pop();
		string = "Seven of Diamonds in Player one's lower palace\n";
		assertEquals(true, pair.equals(test_pair_four));
		assertEquals(string, stack.toString());

		pair = stack.pop();
		string = "";
		assertEquals(true, pair.equals(test_pair_five));
		assertEquals(string, stack.toString());
	}

	/**
	 * The Stack.java class's peek() method test relies on Stack.java's toString() and push() methods.
	 * Therefore, it is crucial for the validity of this test to test Stack.java's toString() and push()
	 * methods first, which are defined within this source file, before testing Stack.java's peek()
	 * method.
	 */
	@Test
	public void peek_test()
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
		assertEquals(string, stack.toString());

		stack.push(test_pair_one);
		string += "Ace of Spades in Player one's hand\n";
		Pair pair = stack.peek();
		assertEquals(true, pair.equals(test_pair_one));
		assertEquals(string, stack.toString());

		stack.push(test_pair_two);
		string = "Eight of Spades in Player two's hand\n" + string;
		pair = stack.peek();
		assertEquals(true, pair.equals(test_pair_two));
		assertEquals(string, stack.toString());

		stack.push(test_pair_three);
		string = "Ace of Clubs in Player one's upper palace\n" + string;
		pair = stack.peek();
		assertEquals(true, pair.equals(test_pair_three));
		assertEquals(string, stack.toString());

		stack.push(test_pair_four);
		string = "Eight of Clubs in Player two's upper palace\n" + string;
		pair = stack.peek();
		assertEquals(true, pair.equals(test_pair_four));
		assertEquals(string, stack.toString());

		stack.push(test_pair_five);
		string = "Seven of Diamonds in Player one's lower palace\n" + string;
		pair = stack.peek();
		assertEquals(true, pair.equals(test_pair_five));
		assertEquals(string, stack.toString());
	}

	/**
	 * The Stack.java class's are_next_four_equal() method test relies on Stack.java's push() method.
	 * Therefore, it is crucial for the validity of this test to test Stack.java's push() method first,
	 * which is defined within this source file, before testing Stack.java's are_next_four_equal() method.
	 */
	@Test
	public void are_next_four_equal_test()
	{
		Pair king_clubs_player_two_lower = new Pair(new Card(KING, CLUBS), PLAYER_TWO_LOWER_PALACE);
		Stack s = new Stack();
		s.push(king_clubs_player_two_lower);
		String str = "King of Clubs in Player two's lower palace\n";
		assertEquals(str, s.toString());

		Random rand = new Random();
		Pair test_pair_one   = new Pair(new Card(ACE,  CLUBS), PLAYER_ONE_HAND);
		Pair test_pair_two   = new Pair(new Card(FOUR, CLUBS), PLAYER_ONE_HAND);
		Pair test_pair_three = new Pair(new Card(FIVE, CLUBS), PLAYER_ONE_HAND);
		Pair test_pair_four  = new Pair(new Card(NINE, CLUBS), PLAYER_ONE_HAND);
		Pair test_pair_five  = new Pair(new Card(JACK, CLUBS), PLAYER_ONE_HAND);
		Stack stack = new Stack();

		for (int i = 0, cnt = 1; i < 5; cnt++)
		{
			stack.push(test_pair_one);
			if (cnt == 4)
			{
				assertEquals(true, stack.are_next_four_equal());
				i++;
				for (int r = 0; r < rand.nextInt(10) + 1; r++)
					switch(rand.nextInt(4))
					{
						case 0:
							stack.push(test_pair_two);
							break;
						case 1:
							stack.push(test_pair_three);
							break;
						case 2:
							stack.push(test_pair_four);
							break;
						case 3:
							stack.push(test_pair_five);
							break;
						default:
							assertEquals("This should", "never happen");
							break;
					}
				cnt = 0;
			}
			else
				assertEquals(false, stack.are_next_four_equal());
		}
	}

	/**
	 * The Stack.java class's is_empty() and clear() tests rely on each other. Therefore, it is crucial
	 * for the validity of these tests, to test them simultaneously. Both tests are defined in this
	 * source file.
	 */
	@Test
	public void is_empty_test()
	{
		Pair test_pair = new Pair(new Card(ACE, CLUBS), PLAYER_ONE_HAND);
		Stack stack = new Stack();

		assertEquals(true, stack.is_empty());

		stack.push(test_pair);
		assertEquals(false, stack.is_empty());

		stack.push(test_pair);
		assertEquals(false, stack.is_empty());

		stack.clear();
		assertEquals(true, stack.is_empty());

		for (int i = 0; i < 5; i++)
			stack.push(test_pair);
		assertEquals(false, stack.is_empty());

		stack.clear();
		assertEquals(true, stack.is_empty());
	}

	/**
	 * The Stack.java class's is_empty() and clear() tests rely on each other. Therefore, it is crucial
	 * for the validity of these tests, to test them simultaneously. Both tests are defined in this
	 * source file.
	 */
	@Test
	public void clear_test()
	{
		Pair test_pair = new Pair(new Card(ACE, CLUBS), PLAYER_ONE_HAND);
		Stack stack = new Stack();
		assertEquals(true, stack.is_empty());

		for (int i = 1; i <= 10; i++)
		{
			for (int j = 1; j <= i; j++)
				stack.push(test_pair);
			assertEquals(false, stack.is_empty());
			stack.clear();
			assertEquals(true, stack.is_empty());
		}
	}

	/**
	 * The Stack.java class's push() and toString() tests rely on each other. Therefore, it is crucial
	 * for the validity of these tests, to test them simultaneously. Both tests are defined in this
	 * source file.
	 */
	@Test
	public void toString_test()
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

	/**
	 * The Stack.java class's equals() method test relies on Stack.java's push() method. Therefore,
	 * it is crucial for the validity of this test to test Stack.java's push() method first, which is
	 * defined within this source file, before testing Stack.java's equals() method.
	 */
	@Test
	public void equals_test()
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

		Stack stack_one = new Stack();
		Stack stack_two = new Stack();
		assertEquals(true, stack_one.equals(stack_two));

		stack_one.push(test_pair_one);
		stack_two.push(test_pair_one);
		assertEquals(true, stack_one.equals(stack_two));

		stack_one.push(test_pair_two);
		stack_two.push(test_pair_two);
		assertEquals(true, stack_one.equals(stack_two));

		stack_one.push(test_pair_three);
		stack_two.push(test_pair_three);
		assertEquals(true, stack_one.equals(stack_two));

		stack_one.push(test_pair_four);
		stack_two.push(test_pair_four);
		assertEquals(true, stack_one.equals(stack_two));

		stack_one.push(test_pair_five);
		stack_two.push(test_pair_five);
		assertEquals(true, stack_one.equals(stack_two));

		stack_one.push(test_pair_one);
		stack_two.push(test_pair_two);
		assertEquals(false, stack_one.equals(stack_two));

		stack_two.pop();
		assertEquals(false, stack_one.equals(stack_two));
	}

	/**
	 * The Stack.java class's size() method test relies on Stack.java's push() method. Therefore,
	 * it is crucial for the validity of this test to test Stack.java's push() method first, which is
	 * defined within this source file, before testing Stack.java's size() method.
	 */
	@Test
	public void size_test()
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
		assertEquals(0, stack.size());

		stack.push(test_pair_one);
		assertEquals(1, stack.size());

		stack.push(test_pair_two);
		assertEquals(2, stack.size());

		stack.push(test_pair_three);
		assertEquals(3, stack.size());

		stack.push(test_pair_four);
		assertEquals(4, stack.size());

		stack.push(test_pair_five);
		assertEquals(5, stack.size());
	}
}