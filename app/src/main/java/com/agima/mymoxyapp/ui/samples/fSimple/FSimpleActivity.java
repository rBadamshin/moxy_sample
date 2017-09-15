package com.agima.mymoxyapp.ui.samples.fSimple;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;

import com.agima.mymoxyapp.R;
import com.agima.mymoxyapp.ui.samples.list.ListScreenActivity;
import com.agima.mymoxyapp.ui.samples.list.ListScreenPresenter;
import com.agima.mymoxyapp.ui.samples.sSimple.SSimpleActivity;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class FSimpleActivity extends MvpAppCompatActivity implements FSimpleView {

    private Button changeColorBtn;

    private View fSimpleView;

    @InjectPresenter
    FSimplePresenter fSimplePresenter;

    private Button forwardNavBtn;

    private Button toListNavBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fsimple);
        bind();
        configure();
    }

    @Override
    public void changeColor(int color) {
        fSimpleView.setBackgroundColor(color);
    }

    private void bind() {
        changeColorBtn = (Button) findViewById(R.id.changeColorBtn);
        fSimpleView = findViewById(R.id.simpleView);
        forwardNavBtn = (Button) findViewById(R.id.forwardNavBtn);
        toListNavBtn = (Button) findViewById(R.id.listNavBtn);
    }

    private void configure() {
        changeColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fSimplePresenter.changeColor();
            }
        });

        forwardNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FSimpleActivity.this, SSimpleActivity.class));
            }
        });

        toListNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FSimpleActivity.this, ListScreenActivity.class));
            }
        });
    }

    @Override
    public void showMessage(@StringRes int resId) {
        Snackbar.make(findViewById(android.R.id.content), resId, Snackbar.LENGTH_LONG).show();
    }
}
