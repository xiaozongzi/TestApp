package com.example.TestApp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import com.example.TestApp.view.SwitchButton;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by yangyong
 * Date: 14-8-11  下午1:49
 */
public class GroupMain extends GroupTest {
    private SwitchButton switchButton;
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
         String s="";
        s="idfefe";


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
