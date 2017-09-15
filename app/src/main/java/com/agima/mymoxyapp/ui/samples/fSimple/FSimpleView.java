package com.agima.mymoxyapp.ui.samples.fSimple;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


public interface FSimpleView extends MvpView {
    //Не смотрим на эту аннотацию :)
    @StateStrategyType(SkipStrategy.class)
    void showMessage(@StringRes int resId);

    void changeColor(int color);
}
