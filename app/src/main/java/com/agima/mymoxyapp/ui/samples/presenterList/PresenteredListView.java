package com.agima.mymoxyapp.ui.samples.presenterList;

import com.agima.mymoxyapp.ui.samples.presenterList.adapter.PresenteredListAdapter;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface PresenteredListView extends MvpView {
    void setAdapter(PresenteredListAdapter adapter);
}
