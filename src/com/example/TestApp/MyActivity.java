package com.example.TestApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    List<Result> list;
    String ss;
    User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc);
        //t.start();
        User userw = new User();

        System.out.println(getJs(userw).get(0));
        System.out.println(getJs(userw).get(1));
        System.out.println(getJs(userw).get(2));
        Class c = User.class;
        String sss = c.getName();
        Field[] f = c.getDeclaredFields();
        System.out.println(f.length);
        for(int i = 0; i < f.length; i++){
            System.out.println(f[i].getName());
        }

        //ts.start();
        findViewById(R.id.po).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ts.interrupt();
                ((TextView) findViewById(R.id.asd)).setText("IT GO");
            }
        });
        //t.start();

        /*setIt(new Call<String>() {
            @Override
            public void fuck(String... ooo) {
                Toast.makeText(MyActivity.this, ooo[0], 1).show();
            }
        });
        list = new ArrayList<Result>();
        Test test = new Test();
        int s =  test.myTest(new Test.NewClass() {
             @Override
             public int test() {
                 return 456;
             }
         });*/
       // lalala();
        //Toast.makeText(MyActivity.this, list.get(0).getSurveyname(), 1).show();

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
             if(msg.what == 1){
                 Toast.makeText(MyActivity.this, user.getPhone(), 1).show();
             } else if(msg.what == 2) {
                 Toast.makeText(MyActivity.this, "dddd", 1).show();
             }
        }
    };

    private Thread ts = new Thread(){
        @Override
        public void run() {
            try{

                while (true){
                    Thread.sleep(1000);
                    System.out.println("---ooo----");
                }

            }  catch (InterruptedException e){
                System.out.println(e.toString() + "0000000");
            }
        }
    };

    private Thread t = new Thread(){
        @Override
        public void run() {

                try {
                    String d = getData();
                    if(d.equals("FUCK")) {
                        handler.sendEmptyMessage(2);
                    } else {
                        try {
                            JSONObject jsonObject = new JSONObject(d);
                            String mess = jsonObject.getString("data");
                            user = new User();
                            List<String> list = getJs(user);
                            JSONObject jsonObject2 = new JSONObject(mess);

                                user.setPhone(jsonObject2.getString(list.get(0)));
                                 user .setEmail(jsonObject2.getString(list.get(1)));
                            handler.sendEmptyMessage(1);
                        } catch (Exception e){

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    };

    class Result{
        String surveyid;
        String surveyname;

        public String getSurveyid() {
            return surveyid;
        }

        public void setSurveyid(String surveyid) {
            this.surveyid = surveyid;
        }

        public String getSurveyname() {
            return surveyname;
        }

        public void setSurveyname(String surveyname) {
            this.surveyname = surveyname;
        }
    }
    class Message{
          String message;
           List<Result>  result;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<Result> getResult() {
            return result;
        }

        public void setResult(List<Result> result) {
            this.result = result;
        }
    }
    private void setIt(Call<String> s) {
        s.fuck("sssssssssssss");
    }

    private String getData(){
        try{
            HttpClient client = new DefaultHttpClient();
            ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            list.add(new BasicNameValuePair("phone", "13739457277"));
            list.add(new BasicNameValuePair("password", "123456"));
            HttpPost post = new HttpPost("http://www.5iwifi.com/wifi_admin4/apiandroid/login");
            post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
            HttpResponse response = client.execute(post);
            client.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        }catch (Exception e){
            System.out.print(e.toString() + "---------------");
            return "FUCK";
        }

    }

    private List<String> getJs(User user){
        Class clazz = user.getClass();
        Field[] file = clazz.getDeclaredFields();

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < file.length; i++){
            String s = file[i].getName();
            list.add(s);
        }
        return list;
    }

    class User extends Object{

        private String phone;
        private String email;
        private int abc;
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAbc() {
            return abc;
        }

        public void setAbc(int abc) {
            this.abc = abc;
        }
    }
}