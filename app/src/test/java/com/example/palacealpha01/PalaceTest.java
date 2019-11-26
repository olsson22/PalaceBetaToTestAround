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

	/**
     * testing the shuffleDeck method so that it at least ensures that the deck is changing.
     * @author Meredith Marcinko, Andres
     */
     @Test
    public void shuffleTheDeckTest()
    {
        PalaceGameState pgs = new PalaceGameState();
        PalaceGameState pgs2 = new PalaceGameState(pgs);

        pgs.shuffleTheDeck();

        assertNotEquals(pgs.toString(), pgs2.toString());
    }//shuffleTheDeckTest

    /**
     * @author Andres Giesemann
     */
    @Test
    public void copyConstructor(){
        PalaceGameState pgs = new PalaceGameState();
        PalaceGameState pgs2 = new PalaceGameState(pgs);

        assertEquals(pgs.toString(), pgs2.toString());
    }//copyConstructor

    /**
     * @author Fredrik Olsson
     */
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
    }//selectCardsTest

    /**
     * @author
     */
    @Test
    public void selectPalaceCardsTest()
    {

    }//selectPalaceCardsTest


    /**
     * tests playCard method from PalaceGameState
     * First, selects a card and then plays it.
     *
     * Checks that the played card is in the discard pile
     * @author Andres Giesemann
     */
    @Test
    public void playCardsTest()
    {
        PalaceGameState pgs = new PalaceGameState();
        Pair temp = new Pair(new Card(Rank.int_to_rank(4), Suit.int_to_suit(1)), Location.DRAW_PILE);
        for (Pair p : pgs.the_deck)
        {
            if (p.get_location() == Location.PLAYER_TWO_HAND)
            {
                pgs.selectCards(2, p);
                temp = p;
                break;
            }
        }

        //done selecting the card, now play it

        pgs.playCards(2);

        for (Pair p : pgs.the_deck) {
            if ((p.get_location() == Location.DISCARD_PILE  || p.get_location() == Location.DEAD_PILE) && p.equals(temp)) {
                assertEquals(p, temp);
            }

        }
    }//playCardsTest

    /**
     * tests changePalace method from PalaceGameState by checking to see that upper palace cards
     * are moved to the proper user's hand.
     * @author Fredrik Olsson
     */
    @Test
    public void changePalaceTest()
    {
        PalaceGameState pgs = new PalaceGameState();
        Pair[] palaceCards = new Pair[3];
        int counter = 0;
        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_TWO_UPPER_PALACE) {
                palaceCards[counter] = p;
                counter++;
            }

        }
        pgs.changePalace(1);
        int counter2 = 0;
        for (int i = 0; i < palaceCards.length; i++) {
            if (palaceCards[i].get_location() == Location.PLAYER_TWO_HAND) {
                counter2++;
            }
        }
        assertEquals(counter2, palaceCards.length);
    }//changePalaceTest

    /**
     * @author
     */
    @Test
    public void confirmPalaceTest()
    {

    }//confirmPalaceTest

    /**
     * tests takeDiscardPile method from PalaceGameState by checking
     * that a card that is in the discard pile is moved to the correct
     * player's hand.
     *
     * Starts by playing a card so that the discard pile is not empty
     * @author Andres Giesemann
     */
    @Test
    public void takeDiscardPileTest()
    {//TODO make this test more rigorous by adding more cards to the discard pile
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

        pgs.playCards(1);
        pgs.takeDiscardPile(1);

        assertEquals(temp.get_location(), Location.PLAYER_TWO_HAND);
    }//takeDiscardPileTest

    /**
     * @author
     */
    @Test
    public void takeFromDrawPileTest()
    {

    }//takeFromDrawPileTest

    /**
     * Tests to see if the deck dealt the right amount of cards
     * to each location, including players' hands and the players' upper palace
     * @author Meredith Marcinko
     */
    @Test
    public void dealTheDeckTest()
    {
        PalaceGameState pgs = new PalaceGameState();
        pgs.dealTheDeck();
        assertEquals(pgs.getPlayerOneHandSize(), 5);
        assertEquals(pgs.getPlayerTwoHandSize(), 5);
        assertEquals(pgs.getPlayerOneUpperPalaceSize(), 3);
        assertEquals(pgs.getPlayerTwoUpperPalaceSize(), 3);


    }//dealTheDeckTest

    /**
     * @author
     */
    @Test
    public void bombDiscardPileTest()
    {

    }//bombDiscardPileTest

    /**
     * checks to see if the draw pile is empty
     * @author Meredith Marcinko
     */
    @Test
    public void isDrawPileEmptyTest()
    {
	    PalaceGameState testpgs = new PalaceGameState();

	    testpgs.isDrawPileEmpty();
	    int after = testpgs.discardPile.size();

	    assertEquals(0, after);

    }//isDrawPileEmptyTest

    /**
     * @author
     */
    @Test
    public void playLowerPalaceCardTest()
    {

        
    }//playLowerPalaceCardTest


}//PalaceTest
