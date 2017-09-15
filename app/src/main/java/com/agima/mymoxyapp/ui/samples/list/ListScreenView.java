package com.agima.mymoxyapp.ui.samples.list;

import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ListScreenView extends MvpView {
    void setTitle(String title);

    void setAdapter(RecyclerView.Adapter adapter);

    @StateStrategyType(SkipStrategy.class)
    void showMessage(@StringRes int resId, int param);
}
