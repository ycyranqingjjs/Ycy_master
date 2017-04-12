package com.qixiaoyi.commonlibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qixiaoyi.commonlibrary.ExceptionCrashHandler;
import com.qixiaoyi.commonlibrary.ioc.ViewUtils;
import com.qixiaoyi.commonlibrary.utils.LogUtils;
import com.qixiaoyi.commonlibrary.utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * --------------------------------------------------
 * 版       权 ：易成勇
 * <p>
 * 作       者： 易成勇
 * <p>
 * 文件名：BaseActiivity
 * <p>
 * 创 建 日 期 ： 2017/4/11 0011  6:39
 * <p>
 * 描      述 ：
 * <p>
 * <p>
 * 修 订 历 史:
 * <p>
 * --------------------------------------------------
 */

public abstract class BaseActiivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置布局layout
        setContentView(getLayoutId());

        //Log.e("TAG", viewRoot + "");

        // 一些特定的算法，子类基本都会使用的
        commonInit();
        // 初始化头部
        ViewUtils.inject(this);
        initTitle();

        // 初始化界面
        initView();

        // 初始化数据
        initData();
    }

    private void commonInit() {
        //View注入

        //工具类初始化
        Utils.init(this);

        //上传异常信息
//        putExtraDataToService();
    }

    //上传错误信息到服务器
    private void putExtraDataToService() {
        //获取上次的崩溃信息 上传服务器
        File crashFile = ExceptionCrashHandler.getInstance().getCrashFile();
        if (crashFile.exists()){
            //上传服务器
            try {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(crashFile));
                char[] buffer = new char[1024];
                int len = 0;
                try {
                    while ((len = reader.read(buffer))!=-1){
                        String str = new String(buffer,0,len);
                        LogUtils.d(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // 初始化数据
    protected abstract void initData();

    // 初始化界面
    protected abstract void initView();

    // 初始化头部
    protected abstract void initTitle();

    // 获取layoutID
    protected abstract int getLayoutId();


    /**
     * 启动Activity
     */
    protected void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * findViewById
     *
     * @return View
     */
    protected <T extends View> T viewById(int viewId) {
        return (T) findViewById(viewId);
    }


}
