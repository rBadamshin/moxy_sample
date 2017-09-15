package com.agima.mymoxyapp.ui.samples.fSimple;


import android.graphics.Color;

import com.agima.mymoxyapp.R;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class FSimplePresenter extends MvpPresenter<FSimpleView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showMessage(R.string.was_first_attach);
    }

    public void changeColor() {
        int color = getRandomColor();
        getViewState().changeColor(color);
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
