package com.example.a1.huangshuai2019120.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a1.huangshuai2019120.Fragment.FragmentOne;
import com.example.a1.huangshuai2019120.Fragment.FragmentTwo;
import com.example.a1.huangshuai2019120.R;

public class Main3Activity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    pager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    pager.setCurrentItem(1);
                    return true;
            }
            return false;
        }
    };
    private LinearLayout container;
    private ViewPager pager;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
           @Override
           public Fragment getItem(int i) {
               switch (i){
                   case 0:
                       return new FragmentOne();
                   case 1:
                       return new FragmentTwo();
               }
               return null;
           }

           @Override
           public int getCount() {
               return 2;
           }
       });
    }

    private void initView() {
        container = (LinearLayout) findViewById(R.id.container);
        pager = (ViewPager) findViewById(R.id.pager);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }
}
