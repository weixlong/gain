package com.wxl.aptmvp;

import com.wxl.apt_annotation.GainField;
import com.wxl.apt_annotation.GainLifecycle;
import com.wxl.mvp.lifecycle.GainActivityLifecycle;
import com.wxl.mvp.util.Loog;

/**
 * create file time : 2020/10/12
 * create user : wxl
 * subscribe :
 */

public class P extends AP implements GainActivityLifecycle {


    @GainField(target = M.class,life = MainActivity.class)
    M m;


    @GainLifecycle(life = MainActivity.class)
    @Override
    public void onResume() {
        Loog.methodE("onResume");
        //m.loadApk();
    }


    @GainLifecycle(life = MainActivity.class)
    @Override
    public void onPause() {
        Loog.methodE("onPause");
    }

    @Override
    public void onStop() {
        Loog.methodE("onStop");
    }

    @Override
    public void onGainAttach() {
        Loog.methodE("onGainAttach");
    }

    @Override
    public void onGainDetach() {
        Loog.methodE("onGainDetach");
    }

    @Override
    public void start() {
        Loog.e("start");
    }
}
