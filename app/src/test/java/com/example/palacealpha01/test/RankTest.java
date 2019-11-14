/**
 * @formatter:off
 */
package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Rank;

import org.junit.Test;

import static com.example.palacealpha01.GameFramework.palace.Rank.ACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.ACE_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.EIGHT;
import static com.example.palacealpha01.GameFramework.palace.Rank.EIGHT_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.FIVE;
import static com.example.palacealpha01.GameFramework.palace.Rank.FIVE_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.FOUR;
import static com.example.palacealpha01.GameFramework.palace.Rank.FOUR_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.JACK;
import static com.example.palacealpha01.GameFramework.palace.Rank.JACK_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.KING;
import static com.example.palacealpha01.GameFramework.palace.Rank.KING_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.NINE;
import static com.example.palacealpha01.GameFramework.palace.Rank.NINE_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.QUEEN;
import static com.example.palacealpha01.GameFramework.palace.Rank.QUEEN_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.SEVEN;
import static com.example.palacealpha01.GameFramework.palace.Rank.SEVEN_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.SIX;
import static com.example.palacealpha01.GameFramework.palace.Rank.SIX_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.TEN;
import static com.example.palacealpha01.GameFramework.palace.Rank.TEN_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.THREE;
import static com.example.palacealpha01.GameFramework.palace.Rank.THREE_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.TWO;
import static com.example.palacealpha01.GameFramework.palace.Rank.TWO_INT;
import static org.junit.Assert.*;

public class RankTest
{

	@Test
	public void get_int_value()
	{
		assertEquals(3, THREE.get_int_value());
		assertEquals(4, FOUR.get_int_value());
		assertEquals(5, FIVE.get_int_value());
		assertEquals(6, SIX.get_int_value());
		assertEquals(7, SEVEN.get_int_value());
		assertEquals(8, EIGHT.get_int_value());
		assertEquals(9, NINE.get_int_value());
		assertEquals(10, JACK.get_int_value());
		assertEquals(11, QUEEN.get_int_value());
		assertEquals(12, KING.get_int_value());
		assertEquals(13, ACE.get_int_value());
		assertEquals(14, TWO.get_int_value());
		assertEquals(15, TEN.get_int_value());

		assertEquals(3, THREE_INT);
		assertEquals(4, FOUR_INT);
		assertEquals(5, FIVE_INT);
		assertEquals(6, SIX_INT);
		assertEquals(7, SEVEN_INT);
		assertEquals(8, EIGHT_INT);
		assertEquals(9, NINE_INT);
		assertEquals(10, JACK_INT);
		assertEquals(11, QUEEN_INT);
		assertEquals(12, KING_INT);
		assertEquals(13, ACE_INT);
		assertEquals(14, TWO_INT);
		assertEquals(15, TEN_INT);
	}

	@Test
	public void int_to_rank()
	{
		assertEquals(THREE, Rank.int_to_rank(3));
		assertEquals(FOUR, Rank.int_to_rank(4));
		assertEquals(FIVE, Rank.int_to_rank(5));
		assertEquals(SIX, Rank.int_to_rank(6));
		assertEquals(SEVEN, Rank.int_to_rank(7));
		assertEquals(EIGHT, Rank.int_to_rank(8));
		assertEquals(NINE, Rank.int_to_rank(9));
		assertEquals(JACK, Rank.int_to_rank(10));
		assertEquals(QUEEN, Rank.int_to_rank(11));
		assertEquals(KING, Rank.int_to_rank(12));
		assertEquals(ACE, Rank.int_to_rank(13));
		assertEquals(TWO, Rank.int_to_rank(14));
		assertEquals(TEN, Rank.int_to_rank(15));

		assertEquals(3, THREE_INT);
		assertEquals(4, FOUR_INT);
		assertEquals(5, FIVE_INT);
		assertEquals(6, SIX_INT);
		assertEquals(7, SEVEN_INT);
		assertEquals(8, EIGHT_INT);
		assertEquals(9, NINE_INT);
		assertEquals(10, JACK_INT);
		assertEquals(11, QUEEN_INT);
		assertEquals(12, KING_INT);
		assertEquals(13, ACE_INT);
		assertEquals(14, TWO_INT);
		assertEquals(15, TEN_INT);
	}
}