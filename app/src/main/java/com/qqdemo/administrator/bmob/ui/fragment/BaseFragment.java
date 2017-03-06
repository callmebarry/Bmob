package com.qqdemo.administrator.bmob.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/28.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(getLayoutResId(),null);
        ButterKnife.bind(this,root);
        init();
        return root;
    }

    protected void init(){
    };

    public abstract int getLayoutResId();
    void goTo(Class clazz){
        Intent intent=new Intent(getActivity(),clazz);
        startActivity(intent);
        getActivity().finish();
    }
    void goTo(Class clazz,boolean isFinish){
        Intent intent=new Intent(getActivity(),clazz);
        startActivity(intent);
        if(isFinish){
            getActivity().finish();
        }

    }

}
