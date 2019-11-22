package com.example.palacealpha01.GameFramework.palace;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import com.example.palacealpha01.GameFramework.Game;
import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.utilities.Logger;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;



/**
 * PalaceSurfaceView Class:
 * the user interface visuals are implemented in this class
 *
 * @author Andres Giesemann, Fredrik Olsson, Meredith Marcinko, Maximilian Puglielli
 * @version November 2019
 */
public class PalaceSurfaceView extends SurfaceView
{

	/**
	 * Initialize variables
	 */
	private PalaceGameState pgs;

	private Paint bitmapPaint = new Paint();
	private Paint selectCardPaint = new Paint();
	private Bitmap cardBack = BitmapFactory.decodeResource(getResources(), R.drawable.back);
	public static final int cardWidth = 108;
	public static final int cardHeight = 150;


	ArrayList<Pair> playerOneHand = new ArrayList<>();
	ArrayList<Pair> playerTwoHand = new ArrayList<>();
	private GamePlayer palaceHumanPlayer;
	private Game theGame;
	private Activity myActivity;
	private Hashtable<String, Bitmap> pictures = new Hashtable<>();
	private int offset = 0;


	/**
	 * Constructor
	 *
	 * @param context
	 */
	public PalaceSurfaceView(Context context)
	{
		super(context);


	}//PalaceSurfaceView

	/**
	 * An alternate constructor for use when a subclass is directly specified
	 * in the layout.
	 *
	 * @param context
	 * @param attrs
	 */
	public PalaceSurfaceView(Context context, AttributeSet attrs)
	{

		super(context, attrs);
		selectCardPaint.setColor(Color.YELLOW);
		setWillNotDraw(false);
		this.pgs = new PalaceGameState();
		for (Pair p : pgs.the_deck) {
			if (p.get_location() == Location.PLAYER_ONE_HAND) {
				playerOneHand.add(p);
			}
			else if (p.get_location() == Location.PLAYER_TWO_HAND) {
				playerTwoHand.add(p);
			}
		}


	}//PalaceSurfaceView

	/**
	 * setPictures method:
	 * palaces the pictures of the cards on the GUI
	 * @param map
	 */
	public void setPictures(Hashtable<String, Bitmap> map)
	{
		this.pictures = map;
	}//setPictures

	/**
	 *setHumanPlayer method:
	 * gets the human player and displays their hand on the GUI
	 * @param p
	 */
	public void setHumanPlayer(GamePlayer p)
	{
		this.palaceHumanPlayer = p;
	}//setHumanPlayer

	/**
	 * setGame method:
	 * sets the game for displaying it on the GUI
	 * @param g
	 */
	public void setGame(Game g)
	{
		this.theGame = g;
	}//setGame

	/**
	 * setActivity method:
	 * shows the activity of the game
	 * @param a
	 */
	public void setActivity(Activity a)
	{
		this.myActivity = a;
	}//setActivity

	/**
	 * onDraw method:
	 * this is the method in which the game is drawn on the GUI
	 * @param canvas
	 */
	public void onDraw(Canvas canvas)
	{

		//pgs.shuffleTheDeck();

		if (pgs == null)
		{
			return;
		}

		//TODO with the help of Nux I tried to change the draw methods so they can differentiate between computerplayer
		//TODO and the humanplayer, for this we need a reference to the human's and computerplayer's playernum but I can't get it to work...
		drawPlayerOnePalaces(canvas, /*second parameter needs to be a reference to the playernum of the humanplayer*/); //done

		drawHands(canvas, /*second parameter needs to be a reference to the playernum of the humanplayer, the third parameter needs to be to the computerplayer*/);//done

		Paint discardPaint = new Paint();
		//used for seeing if discard pile fills up
		discardPaint.setColor(Color.BLUE);


		drawPlayerTwoPalaces(canvas, /*second parameter needs to be a reference to the playernum of the computerplayer*/);//done

		if (pgs.discardPile.peek() != null) {
			int discardX = getWidth() / 2;
			int discardY = getHeight() / 2 - 3 * cardHeight / 4;
			canvas.drawBitmap(pictures.get(pgs.discardPile.peek().get_card().toString()), discardX, discardY, bitmapPaint);
			pgs.discardPile.peek().setX(discardX);
			pgs.discardPile.peek().setY(discardY);
		}
		if (!pgs.isDrawPileEmpty())
		{
			canvas.drawBitmap(cardBack, getWidth() / 2 + cardWidth, getHeight() / 2 - 3 * (cardHeight / 4), bitmapPaint);
		}
	}//onDraw

	/**
	 * drawPlayerTwoPalaces method:
	 * draws player 2's palace
	 * @param canvas
	 */
	//TODO added the playernum parameter to be able to differentiate between computerplayer and humanplayer
	private void drawPlayerTwoPalaces(Canvas canvas, int playerNum)
	{
		Location upLoc = (playerNum == 0)? Location.PLAYER_ONE_UPPER_PALACE : Location.PLAYER_TWO_UPPER_PALACE;
		Location lowLoc = (playerNum == 0)? Location.PLAYER_ONE_LOWER_PALACE : Location.PLAYER_TWO_LOWER_PALACE;

		int xP2LP = getWidth() / 2 - 3 * (cardWidth) / 2;
		int xP2UP = getWidth() / 2 - 3 * (cardWidth) / 2;

		int yP2LP = 50;
		int yP2UP = 75;

		for (Pair p : pgs.the_deck)
		{
			if (p.get_location() == upLoc)
			{
				if (pgs.getSelectedCards().contains(p))
				{
					drawSelectionBox(canvas, xP2LP, yP2LP);
				}
				canvas.drawBitmap(cardBack, xP2LP, yP2LP, bitmapPaint);
				p.setX(xP2LP);
				p.setY(yP2LP);
				xP2LP += cardWidth + 5;
			}

		}

		for (Pair p : pgs.the_deck)
		{
			if (p.get_location() == lowLoc)
			{
				if (pgs.getSelectedCards().contains(p))
				{
					drawSelectionBox(canvas, xP2UP, yP2UP);
				}
				canvas.drawBitmap(pictures.get(p.get_card().toString()), xP2UP, yP2UP, bitmapPaint);
				p.setX(xP2UP);
				p.setY(yP2UP);
				xP2UP += cardWidth + 5;
			}
		}
	}//drawPlayerTwoPalaces

	/**
	 * drawHands method:
	 * draws the cards in the and tells which card is selected
	 * @param canvas
	 */
	//TODO added the playernum parameters to be able to differentiate between computerplayer and humanplayer
	private void drawHands(Canvas canvas, int humanPlayerNum, int computerPlayerNum)
	{


		Location humanHandLoc = (humanPlayerNum == 0)? Location.PLAYER_ONE_HAND : Location.PLAYER_TWO_HAND;
		Location humanUpLoc = (humanPlayerNum == 0)? Location.PLAYER_ONE_UPPER_PALACE : Location.PLAYER_TWO_UPPER_PALACE;
		Location humanLowLoc = (humanPlayerNum == 0)? Location.PLAYER_ONE_LOWER_PALACE : Location.PLAYER_TWO_LOWER_PALACE;

		Location computerHandLoc = (computerPlayerNum == 0)? Location.PLAYER_ONE_HAND : Location.PLAYER_TWO_HAND;
		Location computerUpLoc = (computerPlayerNum == 0)? Location.PLAYER_ONE_UPPER_PALACE : Location.PLAYER_TWO_UPPER_PALACE;
		Location computerLowLoc = (computerPlayerNum == 0)? Location.PLAYER_ONE_LOWER_PALACE : Location.PLAYER_TWO_LOWER_PALACE;

		Paint recPaint = new Paint();
		recPaint.setColor(Color.RED);
		int xP1H = 0;
		int yP1H = getHeight() / 2 + (cardHeight / 2);

		int xP2H = 0;
		int yP2H = getHeight() / 2 - 2 * (cardHeight);

		for (Pair p : pgs.the_deck)
		{
			if (p.get_location() == humanHandLoc && pgs.getSelectedCards().contains(p) ||
					p.get_location() == humanUpLoc && pgs.getSelectedCards().contains(p) ||
					p.get_location() == humanLowLoc && pgs.getSelectedCards().contains(p))
			{
				canvas.drawText("card " + p.toString() + "is selected", 100, 100, recPaint);
			}
		}

		playerOneHand.clear();
		playerTwoHand.clear();

		for (Pair p : pgs.the_deck) {
			if (p.get_location() == humanHandLoc) {
				playerOneHand.add(p);
			}
			else if (p.get_location() == computerHandLoc) {
				playerTwoHand.add(p);
			}
		}

		xP1H = (getWidth()/2) - ((playerOneHand.size()*(cardWidth+5))/2);
		if(xP1H>0) {
			for (Pair p : playerOneHand) {
				if (pgs.getSelectedCards().contains(p)) {
					drawSelectionBox(canvas, xP1H, yP1H);
				}
				canvas.drawBitmap(pictures.get(p.get_card().toString()), xP1H, yP1H, bitmapPaint);
				p.setX(xP1H);
				p.setY(yP1H);
				xP1H += cardWidth + 5;
			}
		}
		else{
			xP1H = 0;
			for (int i = offset; i<playerOneHand.size();i++) {
				if (xP1H + cardWidth < getWidth()) {
					if (pgs.getSelectedCards().contains(playerOneHand.get(i))) {
						drawSelectionBox(canvas, xP1H, yP1H);
					}
					canvas.drawBitmap(pictures.get(playerOneHand.get(i).get_card().toString()), xP1H, yP1H, bitmapPaint);
					playerOneHand.get(i).setX(xP1H);
					playerOneHand.get(i).setY(yP1H);
					xP1H += cardWidth + 5;
				}
			}

		}
		xP2H = (getWidth()/2) - ((playerTwoHand.size()*(cardWidth+5))/2);
		for (Pair p : playerTwoHand) {
			if (pgs.getSelectedCards().contains(p))
			{
				drawSelectionBox(canvas, xP2H, yP2H);
			}
			//canvas.drawBitmap(cardBack, xP2H, yP2H, bitmapPaint);
			canvas.drawBitmap(pictures.get(p.get_card().toString()), xP2H, yP2H, bitmapPaint);
			p.setX(xP2H);
			p.setY(yP2H);
			xP2H += cardWidth + 5;
		}


	}

	public void setOffset(int offset){
		if(this.offset+offset<0){
			return;
		}
		this.offset += offset;
	}

	/**
	 * drawPlayerOnePalaces method:
	 * draws the cards that are within player one's palace
	 * @param canvas
	 */
	//TODO added the playernum parameter to be able to differentiate between computerplayer and humanplayer
	private void drawPlayerOnePalaces(Canvas canvas, int playerNum)
	{
		Location handLoc = (playerNum == 0)? Location.PLAYER_ONE_HAND : Location.PLAYER_TWO_HAND;
		Location upLoc = (playerNum == 0)? Location.PLAYER_ONE_UPPER_PALACE : Location.PLAYER_TWO_UPPER_PALACE;
		Location lowLoc = (playerNum == 0)? Location.PLAYER_ONE_LOWER_PALACE : Location.PLAYER_TWO_LOWER_PALACE;

		int xP1LP = getWidth() / 2 - 3 * (cardWidth) / 2;
		int xP1UP = getWidth() / 2 - 3 * (cardWidth) / 2;
		int yP1LP = getHeight() - 200;
		int height = getHeight();
		int yP1UP = getHeight() - 225;

		for (Pair p : pgs.the_deck)
		{

			if (p.get_location() == lowLoc)
			{

				if (pgs.getSelectedCards().contains(p))
				{
					drawSelectionBox(canvas, xP1LP, yP1LP);
				}
				canvas.drawBitmap(cardBack, xP1LP, yP1LP, bitmapPaint);
				//canvas.drawBitmap(pictures.get(p.get_card().toString()), xP1LP, yP1LP, bitmapPaint);
				p.setX(xP1LP);
				p.setY(yP1LP);
				xP1LP += cardWidth + 5;
			}

		}

		for (Pair p : pgs.the_deck)
		{
			if (p.get_location() == upLoc)
			{
				if (pgs.getSelectedCards().contains(p))
				{
					drawSelectionBox(canvas, xP1UP, yP1UP);
				}
				canvas.drawBitmap(pictures.get(p.get_card().toString()), xP1UP, yP1UP, bitmapPaint);
				p.setX(xP1UP);
				p.setY(yP1UP);
				xP1UP += cardWidth + 5;
			}
		}
	}//drawPlayerOnePalace


	/**
	 * drawSelectionBox method:
	 * draws the box that highlights the card that is selected
	 * @param canvas
	 * @param x
	 * @param y
	 */
	private void drawSelectionBox(Canvas canvas, int x, int y)
	{

		canvas.drawRect(x - 5, y - 5, x + cardWidth + 5, y + cardHeight + 5, selectCardPaint);

	}//drawSelectionBox


	/**
	 * setPgs method:
	 * sets the state of the game
	 * @param pgs
	 */
	public void setPgs(PalaceGameState pgs)
	{
		this.pgs = pgs;
	}//setPgs

}//class PalaceSurfaceView