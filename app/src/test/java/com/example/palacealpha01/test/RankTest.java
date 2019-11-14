package com.example.palacealpha01.test;

import com.example.palacealpha01.GameFramework.palace.Rank;

import org.junit.Test;

import static com.example.palacealpha01.GameFramework.palace.Rank.ACE;
import static com.example.palacealpha01.GameFramework.palace.Rank.ACE_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.JACK;
import static com.example.palacealpha01.GameFramework.palace.Rank.JACK_INT;
import static com.example.palacealpha01.GameFramework.palace.Rank.SEVEN;
import static com.example.palacealpha01.GameFramework.palace.Rank.SEVEN_INT;
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
		assertEquals(7, SEVEN.get_int_value());
		assertEquals(10, JACK.get_int_value());
		assertEquals(13, ACE.get_int_value());
		assertEquals(14, TWO.get_int_value());
		assertEquals(15, TEN.get_int_value());

		assertEquals(3, THREE_INT);
		assertEquals(7, SEVEN_INT);
		assertEquals(10, JACK_INT);
		assertEquals(13, ACE_INT);
		assertEquals(14, TWO_INT);
		assertEquals(15, TEN_INT);
	}

	@Test
	public void int_to_rank()
	{
		assertEquals(THREE, Rank.int_to_rank(3));
		assertEquals(SEVEN, Rank.int_to_rank(7));
		assertEquals(JACK, Rank.int_to_rank(10));
		assertEquals(ACE, Rank.int_to_rank(13));
		assertEquals(TWO, Rank.int_to_rank(14));
		assertEquals(TEN, Rank.int_to_rank(15));

		assertEquals(3, THREE_INT);
		assertEquals(7, SEVEN_INT);
		assertEquals(10, JACK_INT);
		assertEquals(13, ACE_INT);
		assertEquals(14, TWO_INT);
		assertEquals(15, TEN_INT);
	}
}