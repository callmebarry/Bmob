package com.qqdemo.administrator.bmob.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qqdemo.administrator.bmob.Person;
import com.qqdemo.administrator.bmob.R;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/12/29.
 */

public class AddFragment extends BaseFragment {

    @BindView(R.id.bar_title)
    TextView mTitle;
    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.name)
    EditText mName;
    @BindView(R.id.age)
    EditText mAge;
    @BindView(R.id.address)
    EditText mAddress;
    @BindView(R.id.img)
    ImageView mImg;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_add;
    }

    @Override
    protected void init() {
        super.init();
        mTitle.setText("Bmob数据库添加");
    }


    private byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.img, R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img:

                break;
            case R.id.btn:
                Person p = new Person();
                Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.mipmap.aa);
                p.setImg(Bitmap2Bytes(Bitmap.createBitmap(bmp)));
                p.setName(mName.getText().toString());
                p.setAge(Integer.parseInt(mAge.getText().toString()));
                p.setAddress(mAddress.getText().toString());
                p.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(getActivity(), "创建成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "创建失败", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                break;
        }
    }

}
