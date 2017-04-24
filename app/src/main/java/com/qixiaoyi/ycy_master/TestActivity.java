package com.qixiaoyi.ycy_master;

import android.view.View;
import android.widget.Toast;

import com.qixiaoyi.fascialibrary.base.FasiciaBaseActivity;


public class TestActivity extends FasiciaBaseActivity implements View.OnClickListener {
    
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        // 初始化View
        viewById(R.id.test_tv).setOnClickListener(this);
    }

    @Override
    protected void initTitle() {
        // 初始化头部
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, 2/0 + "测试", Toast.LENGTH_LONG).show();
        // Activity   启动流程
    }

}

