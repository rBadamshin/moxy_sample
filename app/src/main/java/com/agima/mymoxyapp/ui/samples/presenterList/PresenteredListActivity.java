package com.agima.mymoxyapp.ui.samples.presenterList;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.agima.mymoxyapp.R;
import com.agima.mymoxyapp.ui.samples.presenterList.adapter.PresenteredListAdapter;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PresenteredListActivity extends MvpAppCompatActivity implements PresenteredListView {

    @BindView(R.id.list)
    RecyclerView recyclerView;

    @BindView(R.id.backBtn)
    Button backBtn;

    @InjectPresenter
    PresenteredListPresenter presenteredListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentered_list);
        ButterKnife.bind(this);

        PresenteredListAdapter listAdapter = new PresenteredListAdapter(getMvpDelegate());
        presenteredListPresenter.setList(listAdapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void setAdapter(PresenteredListAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
