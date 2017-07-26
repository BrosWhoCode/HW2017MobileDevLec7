package com.diglesia.hw2017mobiledev.lec7;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager)findViewById(R.id.view_pager);
        FragmentManager fm = getSupportFragmentManager();
        pager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return GenericFragment.newInstance((int)(Math.random()*65536*65536), (int)(Math.random()*20), (int)(Math.random()*2) == 0 ? R.menu.generic_stuff : R.menu.more_generic_stuff);
            }

            @Override
            public int getCount() {
                return 4;
            }
        });

    }
}
