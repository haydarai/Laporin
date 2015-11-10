package com.bananastech.laporin.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bananastech.laporin.R;
import com.bananastech.laporin.adapters.pager.MainPagerAdapter;
import com.bananastech.laporin.network.RestClient;
import com.loopj.android.http.AsyncHttpClient;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        mTabLayout = (TabLayout) findViewById(R.id.activity_main_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.activity_main_view_pager);
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                mTabLayout.setupWithViewPager(mViewPager);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
