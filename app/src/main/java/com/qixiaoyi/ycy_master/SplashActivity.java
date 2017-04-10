package com.qixiaoyi.ycy_master;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.qixiaoyi.fascialibrary.FasiciaBaseActivity;

public class SplashActivity extends FasiciaBaseActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        TextView tv2 = (TextView) findViewById(R.id.textView);
//        tv.setText(stringFromJNI());
//        tv2.setText(stringFromJNI2());
        startActivity(new Intent(SplashActivity.this, FasiciaBaseActivity.class));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
//    public native String stringFromJNI2();


}
