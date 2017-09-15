package com.agima.mymoxyapp.ui.samples.list;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.agima.mymoxyapp.R;
import com.agima.mymoxyapp.ui.samples.presenterList.PresenteredListActivity;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListScreenActivity extends MvpAppCompatActivity implements ListScreenView {

    @BindView(R.id.list)
    RecyclerView recyclerView;

    @BindView(R.id.titleText)
    TextView titleText;

    @BindView(R.id.toPresenteredListBtn)
    Button toPresenteredListBtn;

    @BindView(R.id.backBtn)
    Button backBtn;

    @InjectPresenter
    ListScreenPresenter listScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        toPresenteredListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListScreenActivity.this, PresenteredListActivity.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void setTitle(String title) {
        titleText.setText(title);
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(@StringRes int resId, int param) {
        Snackbar.make(findViewById(android.R.id.content), getString(resId, param), Snackbar.LENGTH_LONG).show();
    }
}
