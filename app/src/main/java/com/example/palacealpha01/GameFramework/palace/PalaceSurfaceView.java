package com.example.palacealpha01.GameFramework.palace;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import com.example.palacealpha01.GameFramework.Game;
import com.example.palacealpha01.GameFramework.GamePlayer;

public class PalaceSurfaceView extends SurfaceView implements View.OnTouchListener {

    private PalaceGameState pgs;
    private Paint bitmapPaint = new Paint();
    float x;
    float y;
    private GamePlayer humanPlayer;
    private Game theGame;
    private Activity myActivity;

    public PalaceSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);




    }

    public void onDraw(Canvas canvas) {



        x = 10;
        y = 100;
        pgs.shuffleTheDeck();
        for (Pair p : pgs.the_deck) {

            canvas.drawBitmap(p.get_card().getImage(), x, y, bitmapPaint);

            x+=110;
            if (x + 100 > getWidth()) {
                x = 10;
                y += 200;
            }

        }

    }

    public void setPgs(PalaceGameState pgs) {
        this.pgs = pgs;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int tappedX = (int) event.getX();
        int tappedY = (int) event.getY();

        //the ratio between the height and width of the card 72*100.
        double heightRatio= 1.25;

        int nbrOfCards=0;
        for(Pair p: pgs.the_deck){
            if(p.get_location()==Location.PLAYER_ONE_HAND){
                nbrOfCards++;
            }
        }
        if(event.getAction()== MotionEvent.ACTION_DOWN){
            int y = this.getHeight()/2;

            int width = (this.getWidth()/(Math.max(5,nbrOfCards)));
            int height = (int) (width*heightRatio);
            for(Pair p: pgs.the_deck){
                Card c = p.get_card();
                /*here we will have to add how tapping a certain
                * card will affect what will happen to the game, and
                * also send the certain gameaction*/

            }
        }

        return false;
    }


}
