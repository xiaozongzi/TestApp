package com.example.TestApp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
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
    private Animation animationOut ,animationIn;
    TextView textView;
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

        s="      ";
         textView= (TextView) findViewById(R.id.up_text);

        textView.setOnClickListener(listener);
        animationOut= AnimationUtils.loadAnimation(this,R.anim.fade_out);
        animationIn=AnimationUtils.loadAnimation(this,R.anim.fade_in);
        animationIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.setText("11111");
               textView.startAnimation(animationOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
     /*   textView.setAnimation(animation);
        animation.start();*/
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
                 case R.id.up_text:

                     textView.startAnimation(animationIn);

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
