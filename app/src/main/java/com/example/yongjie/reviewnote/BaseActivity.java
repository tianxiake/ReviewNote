package com.example.yongjie.reviewnote;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hiddenActionBar();
    }

    protected boolean isHiddenActionBar() {
        return true;

    }

    protected void hiddenActionBar() {
        if (isHiddenActionBar()) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.hide();
            }
        }
    }
}
