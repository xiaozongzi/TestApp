package com.example.TestApp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;

import android.widget.TextView;
import com.example.TestApp.view.SwitchButton;
import com.jeremyfeinstein.slidingmenu.lib.ActionView;
import com.jeremyfeinstein.slidingmenu.lib.RevealColorView;
import com.jeremyfeinstein.slidingmenu.lib.action.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yangyong
 * Date: 14-8-11  下午1:49
 */
public class GroupMain extends GroupTest {
    private SwitchButton switchButton;
     private ActionView actionView;
    private RevealColorView revealColorView;
    private TextView textView1;
    private int[] color=new int[]{Color.BLUE,Color.RED,Color.GREEN,Color.BLACK,Color.MAGENTA};
    @Override
    protected ViewGroup getContainer() {
        return (ViewGroup)(findViewById(R.id.content));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group);
        findViewById(R.id.text1).setOnClickListener(listener);
        findViewById(R.id.text2).setOnClickListener(listener);
        findViewById(R.id.text3).setOnClickListener(listener);
        actionView= (ActionView) findViewById(R.id.action) ;
        revealColorView= (RevealColorView) findViewById(R.id.revealView);
        textView1= (TextView) findViewById(R.id.text_view_1);
        actionView.setOnClickListener(listener );
        revealColorView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    Random r=new Random();
                    int i=r.nextInt(color.length);
                    revealColorView.reveal(100,0, color[i],null);
                }

               // revealColorView.hide(0,0,Color.GREEN,null);
                return true;
            }
        });

    }
    private void setAction(){
        Action action=actionView.getAction();
         switch (action.getActionId()){
             case 0:
                 actionView.setAction(new BackAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
                 break;
             case 1:
                 actionView.setAction(new CloseAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
                 break;
             case 2:
                 actionView.setAction(new PlusAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
                 break;
             case 3:
                 actionView.setAction(new DrawerAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
                 break;
         }
    }
    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
             switch (view.getId()){
                 case R.id.text1:
                     setMyContent(TestA.class);
                     break;
                 case R.id.text2:
                     setMyContent(TestB.class);
                     break;
                 case R.id.text3:
                     setMyContent(TestC.class);
                     break;
                 case R.id.action:
                     setAction();

                     break;
             }
        }
    };

    private String getHttpString(String url){
        try{
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            //post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
            HttpResponse response = client.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        }catch (Exception e){

        }
        return "";
    }

    private String getRes(String url){
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        StringBuilder builder = new StringBuilder();
        try{
             HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b = 0;
            while ((b = stream.read()) != -1) {
                builder.append((char)b) ;
            }
            return builder.toString();
        }catch (Exception e){

        }
         return "";
    }
}
