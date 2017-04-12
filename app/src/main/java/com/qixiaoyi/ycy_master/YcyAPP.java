package com.qixiaoyi.ycy_master;

import android.app.Application;

import com.alipay.euler.andfix.patch.PatchManager;
import com.qixiaoyi.commonlibrary.ExceptionCrashHandler;
import com.qixiaoyi.commonlibrary.fixbug.FixDexManager;

/**
 * --------------------------------------------------
 * 版       权 ：易成勇
 * <p>
 * 作       者： 易成勇
 * <p>
 * 文件名：YcyAPP
 * <p>
 * 创 建 日 期 ： 2017/4/12 0012  20:09
 * <p>
 * 描      述 ：
 * <p>
 * <p>
 * 修 订 历 史:
 * <p>
 * --------------------------------------------------
 */

public class YcyAPP extends Application {
    public static PatchManager mPatchManager;
    @Override
    public void onCreate() {
        super.onCreate();
        //全局异常捕获
        ExceptionCrashHandler.getInstance().init(this);

        /**
        // 初始化阿里的热修复
        mPatchManager = new PatchManager(this);

        try {
            // 初始化版本，获取当前应用的版本
            PackageManager packageManager = this.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            String versionName = packageInfo.versionName;
            mPatchManager.init(versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // 加载之前的 apatch 包
        mPatchManager.loadPatch();

         */


        try {
            // 很耗时  热启动和冷启动  2s   400 ms
            FixDexManager fixDexManager = new FixDexManager(this);
            // 加载所有修复的Dex包
            fixDexManager.loadFixDex();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
