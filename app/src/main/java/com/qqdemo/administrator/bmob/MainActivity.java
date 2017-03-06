package com.qqdemo.administrator.bmob;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.qqdemo.administrator.bmob.Adapter.FragmentAdapter;
import com.qqdemo.administrator.bmob.ui.fragment.AddFragment;
import com.qqdemo.administrator.bmob.ui.fragment.ListFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;

import static com.qqdemo.administrator.bmob.R.id.TVlist;

public class MainActivity extends FragmentActivity {

    @BindView(TVlist)
    TextView mTVlist;
    @BindView(R.id.TVadd)
    TextView mTVadd;
    @BindView(R.id.VPcontent)
    ViewPager mVPcontent;

    ArrayList<Fragment> list = new ArrayList<Fragment>();
    ArrayList<TextView> textviewlist = new ArrayList<TextView>();
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Bmob.initialize(this, "c1ff88a817ead777179406064a3f0b24");

        initViews();
        changeColor(0);
    }

    private void initViews() {
        ListFragment listFragment = new ListFragment();
        AddFragment addFragment = new AddFragment();
        list.add(listFragment);
        list.add(addFragment);
        adapter = new FragmentAdapter(getSupportFragmentManager(), list);
        mVPcontent.setAdapter(adapter);
        textviewlist.add(mTVlist);
        textviewlist.add(mTVadd);
        mVPcontent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                changeColor(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({TVlist, R.id.TVadd})
    public void onClick(View view) {
        switch (view.getId()) {
            case TVlist:
                mVPcontent.setCurrentItem(0);
                break;
            case R.id.TVadd:
                mVPcontent.setCurrentItem(1);
                break;
        }
    }

    public void changeColor(int index) {
        mTVadd.setTextColor(Color.WHITE);
        mTVlist.setTextColor(Color.WHITE);
        textviewlist.get(index).setTextColor(Color.CYAN);
    }
}
