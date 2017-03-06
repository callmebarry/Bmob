package com.qqdemo.administrator.bmob.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qqdemo.administrator.bmob.MyAdapter;
import com.qqdemo.administrator.bmob.Person;
import com.qqdemo.administrator.bmob.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2016/12/29.
 */

public class ListFragment extends BaseFragment {
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.bar_title)
    TextView mTitle;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void init() {
        super.init();
        mTitle.setText("Bmob数据库列表");

        QuerAll();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               QuerAll();

            }
        });
    }

    private void QuerAll() {
        BmobQuery<Person> query = new BmobQuery<Person>();
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
        query.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> list, BmobException e) {
                if (e == null) {
                    Toast.makeText(getActivity(), "查询成功", Toast.LENGTH_SHORT).show();
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    mRecyclerView.setLayoutManager(linearLayoutManager);
                    MyAdapter myAdapter = new MyAdapter(getActivity(), list);
                    mRecyclerView.setAdapter(myAdapter);
                    mSwipeRefreshLayout.setRefreshing(false);
                } else {
                    Toast.makeText(getActivity(), "查询失败", Toast.LENGTH_SHORT).show();
                    mSwipeRefreshLayout.setRefreshing(false);
                }

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
