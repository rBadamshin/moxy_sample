package com.agima.mymoxyapp.ui.samples.sSimple;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SSimpleView extends MvpView {

    void changeColorSaveState(int color);

    @StateStrategyType(SkipStrategy.class)
    void changeColor(int color);

    @StateStrategyType(SkipStrategy.class)
    void showMessage(@StringRes int resId);

    void setCounterText(String text);
}
