package com.agima.mymoxyapp.ui.samples.sSimple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.agima.mymoxyapp.R;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SSimpleFragment extends MvpAppCompatFragment implements SSimpleView {

    public static Integer constructorCounter = 0;

    @BindView(R.id.changeColorFBtn)
    Button changeColorSaveStateBtn;

    @BindView(R.id.changeColorSBtn)
    Button changeColorBtn;

    @BindView(R.id.simpleFView)
    View simpleSaveStateView;

    @BindView(R.id.simpleSView)
    View simpleView;

    @BindView(R.id.backNavBtn)
    Button backNavBtn;

    @BindView(R.id.forwardNavBtn)
    Button forwardNavBtn;

    @BindView(R.id.counterText)
    TextView counterText;

    @InjectPresenter
    (type = PresenterType.GLOBAL)
    SSimplePresenter sSimplePresenter;

    @ProvidePresenter
    (type = PresenterType.GLOBAL)
    SSimplePresenter nazvalKakHochu() {
        return new SSimplePresenter(constructorCounter++);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        showMessage(R.string.view_destroyed);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ssimple, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configure();
    }

    private void configure() {
        changeColorSaveStateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sSimplePresenter.changeColorSaveState();
            }
        });

        changeColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sSimplePresenter.changeColor();
            }
        });

        backNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        forwardNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragmentContainer, new SSimpleEmptyFragment()).commit();
            }
        });

    }

    @Override
    public void changeColorSaveState(int color) {
        simpleSaveStateView.setBackgroundColor(color);
    }

    @Override
    public void changeColor(int color) {
        simpleView.setBackgroundColor(color);
    }

    @Override
    public void showMessage(@StringRes int resId) {
        Snackbar.make(getView().findViewById(R.id.rootView), resId, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setCounterText(String text) {
        counterText.setText(text);
    }
}
