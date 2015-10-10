package com.example.TestApp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 *
 * Date: 14-8-11  下午2:18
 */
public class TestB extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_group);
        TextView textView = (TextView) findViewById(R.id.test_text);
        textView.setText("bbbbbbbbbb");
    }
}
