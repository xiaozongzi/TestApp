package com.example.TestApp;


import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class GroupTest extends ActivityGroup {

    private ViewGroup group;
    private LocalActivityManager manager;
    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<View>();
    }

    abstract protected ViewGroup getContainer();

    protected void setMyContent(Class<?> activityClass){
        if(null == manager){
            manager = getLocalActivityManager();
        }

        if(null == group){
            group = getContainer();
        }

        group.removeAllViews();
        Intent intent = new Intent(GroupTest.this, activityClass);
     /*   for(int i = 0; i < list.size(); i++){
            if(intent.equals(list.get(i))){
                intent =  list.get(i);
            }else {
                list.add(intent);
            }
        }*/
        View view = manager.startActivity("", intent).getDecorView();
        for(int i = 0; i < list.size(); i++){
            if(view.equals(list.get(i))){
                view =  list.get(i);
            }else {
                list.add(view);
            }
        }
        //加载Activity
        group.addView(view);
    }
}
