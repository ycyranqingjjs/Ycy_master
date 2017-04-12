package com.qixiaoyi.ycy_master;

import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qixiaoyi.commonlibrary.ioc.ViewById;
import com.qixiaoyi.fascialibrary.base.FasiciaBaseActivity;

import java.io.File;
import java.io.IOException;

public class SplashActivity extends FasiciaBaseActivity {

    @ViewById(R.id.sample_text)
    TextView tv;
    @ViewById(R.id.textView)
    TextView tv2;
    // 加载NDK
    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {
        tv.setText(stringFromJNI());
        tv2.setText(stringFromJNI2());
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 2/1;
            }
        });
    }
    @Override
    protected void initData() {

        File fixFile = new File(Environment.getDataDirectory(),"fix.apatch");
        if (fixFile.exists()){
            //修复bug
            try {
                YcyAPP.mPatchManager.addPatch(fixFile.getAbsolutePath());
                Toast.makeText(this, "修复成功", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, "修复失败", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

    }

    //本地方法
    public native String stringFromJNI();
    public native String stringFromJNI2();
}
