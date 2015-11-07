package com.corcow.hw.hwkakaotalk;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.corcow.hw.hwkakaotalk.chatlist.ChatlistFragment;
import com.corcow.hw.hwkakaotalk.friendlist.FriendsFragment;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    TabHost tabHost;
    ViewPager pager;
    TabsAdapter mAdapter;

    private static final String TAB_TAG = "currentTab";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        pager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new TabsAdapter(this, getSupportFragmentManager(), tabHost, pager);

        mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("", getResources().getDrawable(R.drawable.tab_friend_selector)), FriendsFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("", getResources().getDrawable(R.drawable.tab_chatting_selector)), ChatlistFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("", getResources().getDrawable(R.drawable.tab_channel_selector)), ChannelFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab4").setIndicator("", getResources().getDrawable(R.drawable.tab_more_selector)), MoreFragment.class, null);


        mAdapter.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // ...

            }
        });

        if (savedInstanceState != null) {
            mAdapter.onRestoreInstanceState(savedInstanceState);
            tabHost.setCurrentTabByTag(savedInstanceState.getString(TAB_TAG));
        }
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0 :
                        getSupportActionBar().setTitle("친구");
                        break;
                    case 1 :
                        getSupportActionBar().setTitle("채팅");
                        break;
                    case 2 :
                        getSupportActionBar().setTitle("채널");
                        break;
                    case 3 :
                        getSupportActionBar().setTitle("설정");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter.onSaveInstanceState(outState);
        outState.putString(TAB_TAG, tabHost.getCurrentTabTag());
    }
}
