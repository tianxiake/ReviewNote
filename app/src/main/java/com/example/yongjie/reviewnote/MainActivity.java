package com.example.yongjie.reviewnote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.yongjie.reviewnote.fragment.AllFragment;
import com.example.yongjie.reviewnote.fragment.MainFragment;
import com.example.yongjie.reviewnote.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener, IOperation {

    private static final String TAG = "LYJ_MainActivity";
    @BindView(R.id.main_top_title)
    Toolbar tlMainTitle;
    @BindView(R.id.main_bottom_navigation)
    BottomNavigationView bnvMainBottom;
    @BindView(R.id.main_content)
    FrameLayout mainContent;
    private FragmentManager fragmentManager;
    private MainFragment mainFragment;
    private AllFragment allFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tlMainTitle.setOnMenuItemClickListener(this);
        tlMainTitle.inflateMenu(R.menu.top_title_item);
        tlMainTitle.setTitle("ReviewNote");

        mainFragment = new MainFragment();
        allFragment = new AllFragment();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_content, mainFragment);
        fragmentTransaction.commit();

        bnvMainBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                Log.d(TAG, "onNavigationItemSelected:" + itemId);
                switch (itemId) {
                    case R.id.main_bottom_note:
                        //
                        fragmentManager.beginTransaction().replace(R.id.main_content, mainFragment)
                                .commit();
                        break;
                    case R.id.main_bottom_all:
                        //
                        fragmentManager.beginTransaction().replace(R.id.main_content, allFragment)
                                .commit();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.top_statistics:
                ToastUtil.showToast(this, item.getTitle());
                break;
            case R.id.top_setting:
                startActivity(this, SettingsActivity.class);
                ToastUtil.showToast(this, item.getTitle());
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void startActivity(Context context, Class<? extends Activity> clazz) {
        Intent intent = new Intent(context, clazz);
        startActivity(intent);
    }


    @Override
    public void addFragment(Fragment fragment) {
        fragmentManager.beginTransaction().add(R.id.main_content, fragment)
                .commit();
    }

    @Override
    public void addFragmentInBackStack(Fragment fragment, String backStackTag) {
        fragmentManager.beginTransaction().add(R.id.main_content, fragment)
                .addToBackStack(backStackTag)
                .commit();
    }
}
