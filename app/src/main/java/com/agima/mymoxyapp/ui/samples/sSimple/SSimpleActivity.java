package com.agima.mymoxyapp.ui.samples.sSimple;


import android.os.Bundle;

import com.agima.mymoxyapp.R;
import com.arellomobile.mvp.MvpAppCompatActivity;

public class SSimpleActivity extends MvpAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_full);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new SSimpleFragment()).commit();
        }
    }
}
