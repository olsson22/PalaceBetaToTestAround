package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GameComputerPlayer;
import com.example.palacealpha01.GameFramework.infoMessage.GameInfo;
import com.example.palacealpha01.GameFramework.infoMessage.NotYourTurnInfo;

import java.util.ArrayList;

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
			return;

		if (info instanceof PalaceGameState)
		{
			info.setGame(game);
			PalaceGameState pgs = (PalaceGameState) info;

			if (pgs.getTurn() == this.playerNum)
			{
//				sleep(2);

				if (pgs.getSelectedCards().size() > 0)
				{
					game.sendAction(new PalacePlayCardAction(this));
					return;
				}

				ArrayList<Pair> player_two_hand = new ArrayList<>();
				for (Pair p : pgs.the_deck)
					if (p.get_location() == Location.PLAYER_TWO_HAND)
						player_two_hand.add(p);

				if (player_two_hand.size() == 0)
					for (Pair p : pgs.the_deck)
						if (p.get_location() == Location.PLAYER_TWO_UPPER_PALACE)
							player_two_hand.add(p);

				if (player_two_hand.size() == 0)
					for (Pair p : pgs.the_deck)
						if (p.get_location() == Location.PLAYER_TWO_LOWER_PALACE)
							player_two_hand.add(p);

				if (player_two_hand.size() > 0)
				{
					Pair selected_pair = player_two_hand.get((int) (Math.random() * player_two_hand.size()));
					game.sendAction(new PalaceSelectCardAction(this, selected_pair));
					return;
				}

				game.sendAction(new PalaceTakeDiscardPileAction(this));
			}
		}
		//TODO: add functions to make the computer player play cards and not only pick up the discard pile every time.
	}
}
