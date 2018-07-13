package com.example.yongjie.reviewnote.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.yongjie.reviewnote.R;

/**
 * 设置Fragment
 */
public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String TAG = "LYJ_SettingFragment";
    /**
     * 每日复习数key
     */
    private static final String KEY_EVERY_DAY_REVIEW_NUMBER = "review_number";

    /**
     * CheckBox
     */
    private static final String KEY_CHECK_BOX = "CheckBox";
    private ListPreference preference;

    public SettingFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_preference);

        preference = (ListPreference) getPreferenceScreen().findPreference(KEY_EVERY_DAY_REVIEW_NUMBER);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) getPreferenceScreen().findPreference(KEY_CHECK_BOX);
        preference.setOnPreferenceChangeListener(this);
        checkBoxPreference.setOnPreferenceChangeListener(this);

        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String key = preference.getKey();
        switch (key) {
            case KEY_EVERY_DAY_REVIEW_NUMBER:
                Log.d(TAG, "newValue:" + newValue);
                preference.setSummary((CharSequence) newValue);
                break;

            case KEY_CHECK_BOX:
                Log.d(TAG, "newValue:" + true);
                break;

            default:
                break;
        }


        return true;
    }
}
