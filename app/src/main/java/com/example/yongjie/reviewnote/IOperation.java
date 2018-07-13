package com.example.yongjie.reviewnote;

import android.support.v4.app.Fragment;

public interface IOperation {

    void addFragment(Fragment fragment);

    void addFragmentInBackStack(Fragment fragment, String backStackTag);
}
