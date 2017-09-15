package com.agima.mymoxyapp.ui.samples.sSimple;


import android.graphics.Color;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class SSimplePresenter extends MvpPresenter<SSimpleView> {

    private int number;

    SSimplePresenter(int number) {
        this.number = number;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().setCounterText(String.valueOf(number));
    }

    void changeColorSaveState() {
        getViewState().changeColorSaveState(getRandomColor());
    }

    void changeColor() {
        getViewState().changeColor(getRandomColor());
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
