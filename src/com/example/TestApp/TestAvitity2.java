package com.example.TestApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


/**
 *
 * Date: 14-2-26  下午2:27
 */
public class TestAvitity2 extends Activity{
    WebView webView;

    String data="\"<p><span style=\"text-decoration: underline;\">地理空间flak大家</span><br/></p><p><span style=\"text-decoration: underline;\"><video class=\"edui-upload-video  vjs-default-skin video-js\" controls=\"\" preload=\"none\" width=\"420\" height=\"280\" src=\"http://192.168.2.147:8021//Files/0/6ce94cc0ba084e7db8f881c85761126a.mp4\" data-setup=\"{}\"><source src=\"http://192.168.2.147:8021//Files/0/6ce94cc0ba084e7db8f881c85761126a.mp4\" type=\"video/mp4\"/></video></span></p><p><span style=\"text-decoration: underline;\">年大量的</span></p><p><span style=\"text-decoration: underline;\"><video class=\"edui-upload-video  vjs-default-skin video-js\" controls=\"\" preload=\"none\" width=\"420\" height=\"280\" src=\"http://192.168.2.147:8021//Files/0/0a9fedde1ba74d5e9d6ff243948981d3.mp4\" data-setup=\"{}\"><source src=\"http://192.168.2.147:8021//Files/0/0a9fedde1ba74d5e9d6ff243948981d3.mp4\" type=\"video/mp4\"/></video></span></p><p><span style=\"text-decoration: underline;\">拉开大接访的</span></p><p><span style=\"text-decoration: underline;\"><video class=\"edui-upload-video  vjs-default-skin video-js\" controls=\"\" preload=\"none\" width=\"420\" height=\"280\" src=\"http://192.168.2.147:8021//Files/0/77d4c78995dd48938906c109bab9cdc2.mp4\" data-setup=\"{}\"><source src=\"http://192.168.2.147:8021//Files/0/77d4c78995dd48938906c109bab9cdc2.mp4\" type=\"video/mp4\"/></video></span></p><p><span style=\"text-decoration: underline;\"><video class=\"edui-upload-video  vjs-default-skin video-js\" controls=\"\" preload=\"none\" width=\"420\" height=\"280\" src=\"http://192.168.2.147:8021//Files/0/661bae8b503747f094622acc327c316a.mp4\" data-setup=\"{}\"><source src=\"http://192.168.2.147:8021//Files/0/661bae8b503747f094622acc327c316a.mp4\" type=\"video/mp4\"/></video></span></p><p><span style=\"text-decoration: underline;\">打发打发打发</span></p>\"";
  //<p>阿斯蒂芬流动商贩<br/></p><p><img src="http://192.168.2.147:8021//Files/0/1c8f010af8854c228100c294a6c4363c.png" title="sns_tab_close.png" alt="sns_tab_close.png"/></p><p>阿斯多夫地方</p><p><img src="http://192.168.2.147:8021//Files/0/0dfd56541a1d4d10bca884eed0bb33ed.png" title="sns_tab_close.png" alt="sns_tab_close.png"/></p><p><video class="edui-upload-video  vjs-default-skin video-js" controls="" preload="none" width="420" height="280" src="http://192.168.2.147:8021//Files/0/582de2a1de72461f907e7c5b4bd86644.mp4" data-setup="{}"><source src="http://192.168.2.147:8021//Files/0/582de2a1de72461f907e7c5b4bd86644.mp4" type="video/mp4"/></video></p><p>阿斯多夫的</p><p><video class="edui-upload-video  vjs-default-skin video-js" controls="" preload="none" width="420" height="280" src="http://192.168.2.147:8021//Files/0/623f8f89b22e4091ae609203a46a2281.mp4" data-setup="{}"><source src="http://192.168.2.147:8021//Files/0/623f8f89b22e4091ae609203a46a2281.mp4" type="video/mp4"/></video><video class="edui-upload-video  vjs-default-skin video-js" controls="" preload="none" width="420" height="280" src="http://192.168.2.147:8021//Files/0/b201bc300f334b8c8ebd7a292f89f5bb.mp4" data-setup="{}"><source src="http://192.168.2.147:8021//Files/0/b201bc300f334b8c8ebd7a292f89f5bb.mp4" type="video/mp4"/></video><img src="http://192.168.2.147:8021//Files/0/93c9cb2a3bcb4b7788d0a679bf3028e2.png" title="title_feed.png" alt="title_feed.png"/><img src="http://192.168.2.147:8021//Files/0/68c2afb285904b7b92973242d46c82a7.png" title="sns_second_bar.png" alt="sns_second_bar.png"/><img src="http://192.168.2.147:8021//Files/0/a8bd8712d5154bb5b5a83ce3005ef0d8.png" title="title_menu.png" alt="title_menu.png"/></p><p><br/></p>"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        parserHtml();
        webView= (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkLoads(true);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.loadDataWithBaseURL(null,data,null,"UTF-8",null);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
            }
        });
        /*findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestAvitity2.this.finish();
            }
        });*/
        findViewById(R.id.test_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestAvitity2.this,TestA.class);
                startActivity(intent);
            }
        });

    }
    private void parserHtml(){
      /*  Document  document=Jsoup.parse(data);
        Elements element= document.getElementsByTag("object");
        Elements elements= document.getAllElements();*/


    }
}
