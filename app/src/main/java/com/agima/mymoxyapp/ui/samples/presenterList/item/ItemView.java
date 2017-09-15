package com.agima.mymoxyapp.ui.samples.presenterList.item;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
public interface ItemView extends MvpView {
    void setName(String name);

    void setSecondName(String secondName);

    void setCounterText(String counterText);

    void setColor(int color);
}
