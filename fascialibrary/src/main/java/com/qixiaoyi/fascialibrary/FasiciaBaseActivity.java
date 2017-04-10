package com.qixiaoyi.fascialibrary;

import android.os.Bundle;
import android.widget.TextView;

import com.qixiaoyi.commonlibrary.BaseActivity;

public class FasiciaBaseActivity extends BaseActivity {

    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasicia_base);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(stringFromJNI());
    }

    public native String stringFromJNI();
}
