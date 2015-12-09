package com.sumu.gefdemo.base;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by gefufeng on 15/12/8.
 */
public class AppContext extends BaseApplication{
    private boolean isLogin;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 获取App安装包信息
     *
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }



}
