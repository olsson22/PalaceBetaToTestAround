/**
 * @formatter:off
 */
package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Card;
import com.example.palacealpha01.GameFramework.palace.Pair;
import com.example.palacealpha01.GameFramework.palace.Stack;

import org.junit.Test;

import static com.example.palacealpha01.GameFramework.palace.Location.PLAYER_ONE_HAND;
import static com.example.palacealpha01.GameFramework.palace.Rank.ACE;
import static com.example.palacealpha01.GameFramework.palace.Suit.CLUBS;
import static org.junit.Assert.*;

/**
 * @author Maximilian
 *
 * DO NOT DELETE THIS CLASS. IT MAY LOOK USELESS, BUT IT IS NOT. IF YOU HAVE ANY QUESTIONS, ASK ME!
 *
 * The purpose of this class is to test the equals() method from the StackNode class. However, the StackNode
 * class is private, and my not be accessed within the current package. Therefore, if the code block
 * below were to be un-commented, it would error. To fix this, the StackNode class would have to be
 * made public, the 'head' StackNode within the Stack.java class would have to be made public, and the
 * 'next' StackNode within the StackNode class would have to be made public. This unit test has been
 * run successfully, so there is no need to execute any of the instructions specified above.
 */
public class StackNodeTest
{
/*	@Test
	public void equals_test()
	{
		Pair test_pair_one = new Pair(new Card(ACE, CLUBS), PLAYER_ONE_HAND);
		Pair test_pair_two = new Pair(new Card(ACE, CLUBS), PLAYER_ONE_HAND);

		assertEquals(true, test_pair_one.equals(test_pair_two));

		Stack stack = new Stack();
		stack.push(test_pair_one);
		stack.push(test_pair_two);

		assertEquals(true, stack.head.equals(stack.head.next));
	}
*/
}