package com.android.imaginative;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.imaginative.bookkeeping.BookKeepFragment;
import com.android.imaginative.home.HomeFragment;
import com.android.imaginative.mine.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNav;

    private HomeFragment homeFragment;
    private BookKeepFragment bookKeepFragment;
    private MineFragment mineFragment;

    private Fragment[] mFragments = new Fragment[5];
    private int mPreFragmentFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        this.getSupportActionBar().hide();
        initView();

    }

    private void initView() {
        mBottomNav = (BottomNavigationView) findViewById(R.id.main_bottom_navigation_view);

        homeFragment = new HomeFragment();
        bookKeepFragment = new BookKeepFragment();
        mineFragment = new MineFragment();
        mFragments = new Fragment[]{homeFragment , bookKeepFragment , mineFragment};
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_select_fragment_view, homeFragment)
                .commit();
        mBottomNav.setOnNavigationItemSelectedListener(mNavItemSelect);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mNavItemSelect = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.main_navigation_home:
                    switchFragment(mFragments[0]);
                    return true;
                case R.id.main_navigation_bookkeeping:
                    switchFragment(mFragments[1]);
                    return true;
                case R.id.main_navigation_mine:
                    switchFragment(mFragments[2]);
                    return true;
            }
            return false;
        }
    };

    // 切换fragment
    private void switchFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_select_fragment_view, fragment);
        transaction.commitAllowingStateLoss();
    }

}