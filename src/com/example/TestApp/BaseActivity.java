package com.example.TestApp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ${zhangzz} on 2016/1/20.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("lifeCick","onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("lifeCick","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("lifeCick","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("lifeCick","onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e("lifeCick","onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("lifeCick","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("lifeCick","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("lifeCick","onDestroy");
    }

    @Override
    public void recreate() {
        super.recreate();
        Log.e("lifeCick","recreate");
    }
}
