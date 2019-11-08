package com.example.palacealpha01.GameFramework.palace;

import android.util.Log;

import com.example.palacealpha01.GameFramework.GameComputerPlayer;
import com.example.palacealpha01.GameFramework.infoMessage.GameInfo;
import com.example.palacealpha01.GameFramework.infoMessage.NotYourTurnInfo;

import java.util.ArrayList;
import java.util.Random;

public class PalaceComputerPlayer extends GameComputerPlayer
{


	public PalaceComputerPlayer(String name)
	{
		super(name);
	}

	@Override
	protected void receiveInfo(GameInfo info)
	{
		if (info instanceof NotYourTurnInfo)
		{
			return;
		}

		//TODO: add functions to make the computer player play cards and not only pick up the discard pile every time.
		game.sendAction(new PalaceTakeDiscardPileAction(this));
		sleep(2);


		//game.sendAction(new PalaceSkipTurn(this));

	}
}
