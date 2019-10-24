package com.example.palacealpha01.GameFramework.palace;

import android.app.Activity;
import android.view.View;

import com.example.palacealpha01.GameFramework.GameHumanPlayer;
import com.example.palacealpha01.GameFramework.GameMainActivity;
import com.example.palacealpha01.GameFramework.infoMessage.GameInfo;


//needs to handle screen interaction (implement listeners)
public class PalaceHumanPlayer extends GameHumanPlayer {


    private Activity myActivity;

    private PalaceSurfaceView palaceSurfaceView;

    //TTT uses layout ID as well

    public PalaceHumanPlayer(String name) {
        super(name);
    }


    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

        //getTopView().getContext().getResources()

    }

    @Override
    //can access mainActivity from this class for resources
    public void setAsGui(GameMainActivity activity) {

        myActivity = activity;
        //layoutID set here

    }

    @Override
    public void sendInfo(GameInfo info) {

    }
}
