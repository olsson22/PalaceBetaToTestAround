package com.example.palacealpha01;

import com.example.palacealpha01.GameFramework.palace.Card;
import com.example.palacealpha01.GameFramework.palace.Location;
import com.example.palacealpha01.GameFramework.palace.Pair;
import com.example.palacealpha01.GameFramework.palace.PalaceGameState;
import com.example.palacealpha01.GameFramework.palace.Rank;
import com.example.palacealpha01.GameFramework.palace.Suit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


/**
 * Tests the Methods in the PalaceGameState
 *
 * @author  Andres, Maximilian, Fredrik, Meredith
 * @version 5 November 2019
 */
public class PalaceTest
{

	//testing the shuffleDeck function
	//doesn't need to be tested because the outcome
	// of the shuffle will be different every time the
	// method is called
	//Meredith Marcinko

    //Andres: updated the shuffleTheDeck test method so that it at least ensures that the deck is changing.
    @Test
    public void shuffleTheDeckTest()
    {
        PalaceGameState pgs = new PalaceGameState();
        PalaceGameState pgs2 = new PalaceGameState(pgs);

        pgs.shuffleTheDeck();

        assertNotEquals(pgs.toString(), pgs2.toString());
    }

    @Test
    public void copyConstructor(){
        PalaceGameState pgs = new PalaceGameState();
        PalaceGameState pgs2 = new PalaceGameState(pgs);

        assertEquals(pgs.toString(), pgs2.toString());
    }

    @Test
    public void selectCardsTest()
    {
        PalaceGameState pgs = new PalaceGameState();
        Pair temp = new Pair(new Card(Rank.int_to_rank(4), Suit.int_to_suit(1)), Location.DRAW_PILE);
        for (Pair p : pgs.the_deck)
        {
            if (p.get_location() == Location.PLAYER_TWO_HAND)
            {
                pgs.selectCards(1, p);
                temp = p;
                break;
            }
        }

        assertTrue(pgs.getSelectedCards().contains(temp));
    }

    @Test
    public void selectPalaceCardsTest()
    {

    }

    @Test
    public void playCardsTest()
    {

    }

    @Test
    public void changePalaceTest()
    {

    }

    @Test
    public void confirmPalaceTest()
    {

    }

    @Test
    public void takeDiscardPilTest()
    {

    }

    @Test
    public void dealTheDeckTest()
    {

    }

    @Test
    public void bombDiscardPileTest()
    {

    }

    @Test
    public void isDrawPileEmptyTest()
    {

    }
}
