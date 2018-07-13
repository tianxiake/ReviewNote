package com.example.yongjie.reviewnote;

import android.os.Bundle;

import com.example.yongjie.reviewnote.fragment.SettingFragment;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("设置");
//        setContentView(R.layout.activity_settings);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingFragment())
                .commit();

    }


    @Override
    protected boolean isHiddenActionBar() {
        return false;
    }
}
