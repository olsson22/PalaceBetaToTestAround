package com.example.palacealpha01.GameFramework.palace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class CardSurfaceView extends SurfaceView implements View.OnTouchListener
{

	private PalaceGameState pgs;
	private Paint bitmapPaint = new Paint();
	float x;
	float y;

	public CardSurfaceView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		setWillNotDraw(false);

	}

	public void onDraw(Canvas canvas)
	{
		x = 10f;
		y = 100f;
		pgs.shuffleTheDeck();
		for (Pair p : pgs.the_deck)
		{
			p.get_card().draw(canvas, x, y, bitmapPaint);
//			canvas.drawBitmap(p.get_card().getImage(), x, y, bitmapPaint);

			x += 110f;
			if (x + 100f > getWidth())
			{
				x = 10f;
				y += 200f;
			}
		}
	}

	public void setPgs(PalaceGameState pgs)
	{
		this.pgs = pgs;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event)
	{

		return false;
	}
}
