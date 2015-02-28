package com.example.TestApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by yangyong
 * Date: 14-2-26  下午2:27
 */
public class TestAvitity2 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestAvitity2.this.finish();
            }
        });
    }
}
