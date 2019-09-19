package com.android.sys.appdefault.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

/**
 * Created by mtcle
 */

public class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected ProgressDialog pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        x.view().inject(this);
        pb = new ProgressDialog(this);
        initView();
        initData();
    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected Activity getActivity() {
        return this;
    }

    protected void updateProgress(String content) {
        pb.setMessage(content);
        pb.show();
    }

    protected void closeProgress() {
        if (pb != null && pb.isShowing()) {
            pb.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeProgress();
    }
}
