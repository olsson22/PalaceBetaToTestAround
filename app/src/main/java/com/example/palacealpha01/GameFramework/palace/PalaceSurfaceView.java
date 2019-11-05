package com.example.palacealpha01.GameFramework.palace;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import com.example.palacealpha01.GameFramework.Game;
import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.utilities.Logger;
//import com.example.palacealpha01.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class PalaceSurfaceView extends SurfaceView implements View.OnTouchListener, View.OnClickListener  {

    private PalaceGameState pgs;

    private Paint bitmapPaint = new Paint();
    private Paint selectCardPaint = new Paint();
    private Bitmap cardBack = BitmapFactory.decodeResource(getResources(), R.drawable.back);
    private final int cardWidth = cardBack.getWidth();
    private final int cardHeight = cardBack.getHeight();
    ArrayList<Pair> discardPile = new ArrayList<>();
    private GamePlayer palaceHumanPlayer;
    private Game theGame;
    private Activity myActivity;
    private Hashtable<String, Bitmap> pictures = new Hashtable<>();



    public PalaceSurfaceView(Context context){
        super(context);
    }

    public PalaceSurfaceView(Context context, AttributeSet attrs) {


        super(context, attrs);
        selectCardPaint.setColor(Color.YELLOW);
        setWillNotDraw(false);
        this.pgs = new PalaceGameState();

    }

    public void setPictures(Hashtable<String, Bitmap> map){
    	this.pictures = map;
	}
    public void setHumanPlayer(GamePlayer p){
        this.palaceHumanPlayer=p;
    }
    public void setGame(Game g){
        this.theGame = g;
    }
    public void setActivity(Activity a){
        this.myActivity = a;
    }

    public void onDraw(Canvas canvas) {

        //pgs.shuffleTheDeck();

        if(pgs == null){
            return;
        }
        drawPlayerOnePalaces(canvas);

        drawHands(canvas);
        //used for seeing if discard pile fills up
        Paint discardPaint = new Paint();
        //used for seeing if discard pile fills up
        discardPaint.setColor(Color.BLUE);


        drawPlayerTwoPalaces(canvas);
        //used for seeing if discard pile fills up
        int counter = 0;
        //TODO: we have to change this so it fits with the stack that Max wrote.
        for(int i = pgs.the_deck.size()-1;i>=0;i--)
        {
            canvas.drawText("cards in discard pile: " + counter, 200, 10*counter,discardPaint );
            if(pgs.the_deck.get(i).get_location()==Location.DISCARD_PILE)
            {
                canvas.drawBitmap(pictures.get(pgs.the_deck.get(i).get_card().toString()), getWidth() / 2, getHeight() / 2 - 3 * cardHeight / 4, bitmapPaint);

            counter++;
            }
        }



        if (!pgs.isDrawPileEmpty()) {
            canvas.drawBitmap(cardBack, getWidth()/2 + cardWidth, getHeight()/2 - 3*(cardHeight/4), bitmapPaint);
        }


    }

    private void drawPlayerTwoPalaces(Canvas canvas) {

        int xP2LP = getWidth()/2 - 3*(cardWidth)/2;
        int xP2UP = getWidth()/2 - 3*(cardWidth)/2;

        int yP2LP = 50;
        int yP2UP = 75;

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_TWO_LOWER_PALACE) {
                if (pgs.getSelectedCards().contains(p)) {
                    drawSelectionBox(canvas, xP2LP, yP2LP);
                }
                canvas.drawBitmap(cardBack, xP2LP, yP2LP, bitmapPaint);
                xP2LP += cardWidth + 5;
            }

        }

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_TWO_UPPER_PALACE) {
                if (pgs.getSelectedCards().contains(p)) {
                    drawSelectionBox(canvas, xP2UP, yP2UP);
                }
                canvas.drawBitmap(pictures.get(p.get_card().toString()), xP2UP, yP2UP, bitmapPaint);
                xP2UP += cardWidth + 5;
            }
        }
    }

    private void drawHands(Canvas canvas) {
        Paint recPaint = new Paint();
        recPaint.setColor(Color.RED);
        int xP1H = 0;
        int yP1H = getHeight()/2 + (cardHeight/2);

        int xP2H = 0;
        int yP2H = getHeight()/2 - 2*(cardHeight);

        for(Pair p : pgs.the_deck){
            if(p.get_location() == Location.PLAYER_ONE_HAND && pgs.getSelectedCards().contains(p)|| p.get_location()==Location.PLAYER_ONE_UPPER_PALACE && pgs.getSelectedCards().contains(p)|| p.get_location()==Location.PLAYER_ONE_LOWER_PALACE&&pgs.getSelectedCards().contains(p)){
                canvas.drawText("card " + p.toString() + "is selected", 100,100,recPaint);
            }
        }

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_ONE_HAND) {
                if (pgs.getSelectedCards().contains(p)) {
                    drawSelectionBox(canvas, xP1H, yP1H);
                }
                canvas.drawBitmap(pictures.get(p.get_card().toString()), xP1H, yP1H, bitmapPaint);
                xP1H += cardWidth + 5;
            }
        }

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_TWO_HAND) {
                if (pgs.getSelectedCards().contains(p)) {
                    drawSelectionBox(canvas, xP2H, yP2H);
                }
                canvas.drawBitmap(pictures.get(p.get_card().toString()), xP2H, yP2H, bitmapPaint);
                xP2H += cardWidth + 5;
            }
        }

    }

    private void drawPlayerOnePalaces(Canvas canvas) {

        int xP1LP = getWidth()/2 - 3*(cardWidth)/2;
        int xP1UP = getWidth()/2 - 3*(cardWidth)/2;
        int yP1LP = getHeight() - 200;
        int height = getHeight();
        int yP1UP = getHeight() - 225;



        for (Pair p : pgs.the_deck) {

            if (p.get_location() == Location.PLAYER_ONE_LOWER_PALACE) {

                if (pgs.getSelectedCards().contains(p)) {
                    drawSelectionBox(canvas, xP1LP, yP1LP);
                }
                canvas.drawBitmap(cardBack, xP1LP, yP1LP, bitmapPaint);
                xP1LP += cardWidth + 5;
            }

        }

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_ONE_UPPER_PALACE) {
                if (pgs.getSelectedCards().contains(p)) {
                    drawSelectionBox(canvas, xP1UP, yP1UP);
                }
				canvas.drawBitmap(pictures.get(p.get_card().toString()), xP1UP, yP1UP, bitmapPaint);
                xP1UP += cardWidth + 5;
            }
        }
    }
//bit of a mess, but this handles the clicks on the different cards
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int nbrCardsInHand = 0;
        int nbrCardsInUP = 0;
        int sVHeight = 1092;
        int cardHeight = 130;
        int cardWidth = 110;
        int xDiscard = getWidth()/2;
        int yDiscard = getHeight()/2 - 3*cardHeight/4;
        int xUpperPalace = getWidth()/2 - 3*(cardWidth)/2;
        int yUpperPalace = getHeight() - 225;
        int xLowerPalace = xUpperPalace;
        int yLowerPalace = getHeight()-200;
        int clickedX = (int) event.getX();
        int clickedY = (int) event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            int top = (sVHeight / 2) + (cardHeight / 2);
            int left = 0;
            int right = left + cardWidth;
            int bottom = top + cardHeight;


            for (Pair p : pgs.the_deck)
            {
               //if a card in player ones hand is tapped, select that card
                if (p.get_location() == Location.PLAYER_ONE_HAND)
                {
                    nbrCardsInHand++;
                    nbrCardsInUP++;
                    PalaceSelectCardAction selectCard = new PalaceSelectCardAction(palaceHumanPlayer, p);

                    if (clickedX >= left && clickedY >= top && clickedX <= right && clickedY <= bottom)
                    {
                        theGame.sendAction(selectCard);
                    }
                    left += cardWidth + 5;
                    right = left + cardWidth + 5;

                }

                //if the discard pile is tapped, then pick up the discard pile
                else if (p.get_location() == Location.PLAYER_ONE_UPPER_PALACE && nbrCardsInHand==0)
                {
                    nbrCardsInUP++;
                    PalaceSelectCardAction selectCard = new PalaceSelectCardAction(palaceHumanPlayer, p);
                    if (clickedX >= xUpperPalace && clickedY >= yUpperPalace && clickedX < (xUpperPalace + cardWidth) && clickedY < (yUpperPalace + cardHeight))
                    {
                        theGame.sendAction(selectCard);
                    }
                    xUpperPalace += cardWidth + 5;
                }
                else if (p.get_location() == Location.PLAYER_ONE_LOWER_PALACE && nbrCardsInHand==0 && nbrCardsInUP==0)
                {
                    PalaceSelectCardAction selectCard = new PalaceSelectCardAction(palaceHumanPlayer, p);
                    if (clickedX >= xLowerPalace && clickedY >= yLowerPalace && clickedX < (xLowerPalace + cardWidth) && clickedY < (yLowerPalace + cardHeight))
                    {
                        theGame.sendAction(selectCard);
                    }
                    xLowerPalace += cardWidth + 5;
            }
                else if (p.get_location() == Location.DISCARD_PILE)
                {
                    PalaceTakeDiscardPileAction takeDiscard = new PalaceTakeDiscardPileAction(palaceHumanPlayer);
                    if (clickedX >= xDiscard && clickedY >= yDiscard && clickedX < (xDiscard + cardWidth) && clickedY < (yDiscard + cardHeight))
                    {
                        theGame.sendAction(takeDiscard);
                        invalidate();
                    }
                }
            }
        }
            invalidate();
        return true;}

    private void drawSelectionBox(Canvas canvas, int x, int y) {

        canvas.drawRect(x - 5, y - 5, x + cardWidth + 5, y + cardHeight + 5, selectCardPaint);

    }


    public void setPgs(PalaceGameState pgs)
    {
        this.pgs = pgs;
    }

    public void setDiscardPile(ArrayList<Pair> discardPile)
    {
        this.discardPile = discardPile;
    }

        //Since the playCard-button needs to know about the GameState I implemented this listener here.
        @Override
        public void onClick(View button)
        {
         if(button.getId() == R.id.playCardButton)
         {
            for(Pair p: pgs.getSelectedCards())
            {
                if (pgs.getSelectedCards().contains(p)){
                    PalacePlayCardAction playCardAction = new PalacePlayCardAction(palaceHumanPlayer);
                    theGame.sendAction(playCardAction);
                    button.invalidate();
                }
            }
        }
    }
}