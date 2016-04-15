package com.example.TestApp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 *
 * Date: 14-8-11  下午2:19
 */
public class TestC extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_group);
        TextView textView = (TextView) findViewById(R.id.test_text);
        textView.setText("ccccc");
        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestC.this,TestAvitity2.class);
                startActivity(intent);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent(TestC.this,TestAvitity2.class);
                startActivity(intent);
                finish();*/
                initView();
            }
        });

    }


    private void initView() {
        Dialog dialog=new TimePickerDialog(this,R.style.mydialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        }, 24,60,true);
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
    }
}
