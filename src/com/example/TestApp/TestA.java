package com.example.TestApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

/**
 *
 * Date: 14-8-11  下午2:17
 */
public class TestA extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_group);
        final TextView textView = (TextView) findViewById(R.id.test_text);
        doit("7-3*1+12-2*1+2");
        //Toast.makeText(this, String.valueOf("a".substring(0, 1)), 1).show();
        textView.setText("aaaaaaaa");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestA.this,TestC.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        });
        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("adadadadad");
            }
        });
    }

    private boolean hasJJJ(String d){
        if(d.equals("*") || d.equals("/") || d.equals("+") || d.equals("-")){
            return false;
        } else {
            return true;
        }
    }

    private List<Integer> ff(String sd){
        char[] chars = sd.toCharArray();
        List<Integer> list = new ArrayList<Integer>();
        int length = sd.length();
        for(int i = 0; i < length - 1; i++){
            String s = chars[i] + "";
            if(!hasJJJ(s)){
                list.add(i);
            }
        }
        return list;
    }

    private List<Integer> dsd(String dd){

        List<Integer> list = ff(dd);
        List<Integer> list2 = new ArrayList<Integer>();
        int length = list.size();
        int index = 0;
        for(int i = 0; i < length; i++){
             int index2= list.get(i);
            String s = "";
            if(i == 0){
                s = dd.substring(index, index2);
            }else {
               s =  dd.substring(index + 1, index2 );
            }

            index = index2;
            if(!s.equals(""))
            list2.add(Integer.parseInt(s));
            if(i == length -1){
                list2.add(Integer.parseInt(dd.substring(index2 + 1, dd.length())));
            }
        }
        return list2;
    }

    private boolean hasAAA(String d){
        if(d.contains("*") || d.contains("/")){
            return false;
        } else {
            return true;
        }
    }

    private boolean hasBBB(String d){
        if(d.contains("+") || d.contains("-")){
            return false;
        } else {
            return true;
        }
    }

    private void doit(String sss){

        int b = 0;
        int a =0;
        String ss = sss;
        do{
            List<Integer> list = ff(ss);
            List<Integer> list2 = dsd(ss);
            int ab = ss.indexOf("*");
            int ac = ss.indexOf("/");
            if(ab == ac){
                return;
            } else if((ab < ac && ab != -1 && ac != -1) || ab > ac){
                if(ss.contains("*")){
                    int index = ss.indexOf("*");
                    for(int k = 0; k < list.size(); k++){
                        if(list.get(k) == index){
                            a = list2.get(k);
                            b = list2.get(k + 1);
                        }
                    }
                    int total = a * b;
                    String ss1 = ss.substring(0, index - String.valueOf(a).length());
                    int abc =  index + String.valueOf(b).length() + 1;
                    String ss2 = "";
                    if(abc < ss.length()){
                        ss2 = ss.substring(index + String.valueOf(b).length() + 1, ss.length());
                    }
                    ss = ss1 + total + ss2;

                }else if(ss.contains("/")){
                    int index = ss.indexOf("/");
                    for(int k = 0; k < list.size(); k++){
                        if(list.get(k) == index){
                            a = list2.get(k);
                            b = list2.get(k + 1);
                        }
                    }
                    int total = a / b;
                    String ss1 = ss.substring(0, index - String.valueOf(a).length());
                    int abc =  index + String.valueOf(b).length() + 1;
                    String ss2 = "";
                    if(abc < ss.length()){
                        ss2 = ss.substring(index + String.valueOf(b).length() + 1, ss.length());
                    }
                    ss = ss1 + total + ss2;
                }
            }else if((ab > ac && ab != -1 && ac != -1) || ab < ac){
                    if(ss.contains("/")){
                        int index = ss.indexOf("/");
                        for(int k = 0; k < list.size(); k++){
                            if(list.get(k) == index){
                                a = list2.get(k);
                                b = list2.get(k + 1);
                            }
                        }
                        int total = a / b;
                        String ss1 = ss.substring(0, index - String.valueOf(a).length());
                        int abc =  index + String.valueOf(b).length() + 1;
                        String ss2 = "";
                        if(abc < ss.length()){
                            ss2 = ss.substring(index + String.valueOf(b).length() + 1, ss.length());
                        }
                        ss = ss1 + total + ss2;
                    }else if(ss.contains("*")){
                        int index = ss.indexOf("*");
                        for(int k = 0; k < list.size(); k++){
                            if(list.get(k) == index){
                                a = list2.get(k);
                                b = list2.get(k + 1);
                            }
                        }
                        int total = a * b;
                        String ss1 = ss.substring(0, index - String.valueOf(a).length());
                        int abc =  index + String.valueOf(b).length() + 1;
                        String ss2 = "";
                        if(abc < ss.length()){
                            ss2 = ss.substring(index + String.valueOf(b).length() + 1, ss.length());
                        }
                        ss = ss1 + total + ss2;
                }

            }
          }  while (!hasAAA(ss));
        List<Integer> list = ff(ss);
        List<Integer> list2 = dsd(ss);
            do{
                if(ss.contains("+")){
                    int index = ss.indexOf("+");
                    for(int k = 0; k < list.size(); k++){
                        if(list.get(k) == index){
                            a = list2.get(k);
                            b = list2.get(k + 1);
                        }
                    }
                    int total = a + b;
                    String ss1 = ss.substring(0, index - String.valueOf(a).length());
                    int abc =  index + String.valueOf(b).length() + 1;
                    String ss2 = "";
                    if(abc < ss.length()){
                        ss2 = ss.substring(index + String.valueOf(b).length() + 1, ss.length());
                    }
                    ss = ss1 + total + ss2;
                } else if(ss.contains("-")){
                    int index = ss.indexOf("-");
                    for(int k = 0; k < list.size(); k++){
                        if(list.get(k) == index){
                            a = list2.get(k);
                            b = list2.get(k + 1);
                        }
                    }
                    int total = a - b;
                    String ss1 = ss.substring(0, index - String.valueOf(a).length());
                    int abc =  index + String.valueOf(b).length() + 1;
                    String ss2 = "";
                    if(abc < ss.length()){
                        ss2 = ss.substring(index + String.valueOf(b).length() + 1, ss.length());
                    }
                    ss = ss1 + total + ss2;

                }
        } while (!hasBBB(ss));
        Toast.makeText(this, ss, 1).show();
    }
}
