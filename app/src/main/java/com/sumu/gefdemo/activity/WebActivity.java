package com.sumu.gefdemo.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.sumu.gefdemo.R;

public class WebActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webview);
//        webView.loadUrl("http://www.gefufeng.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAppCacheEnabled(true);

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/gefdemoweb";
        Log.e(null,path);
        webSettings.setAppCachePath(path);
        webView.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Log.e("webview", "url" + url);
//                view.loadUrl(url);
//                return true;
//            }


            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e("webview", "onReceivedError1");
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Log.e("webview", "onReceivedErro2");
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                Log.e("webview", "onReceivedHttpError");
                super.onReceivedHttpError(view, request, errorResponse);
            }
        });
        webView.requestFocusFromTouch();
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int newProgress) {
                Log.e("webview", "newProgress" + newProgress);
            }

            public void onReceivedTitle(WebView view, String title) {
                Log.e("webview", "title" + title);
            }
        });

        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this, "test");
        webView.loadUrl("file:///android_asset/js_web.html");
    }
    @JavascriptInterface
    public void hello(String msg){
        Log.e("webview","hello");
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
    @JavascriptInterface
    public void hello1(){
        Log.e("webview", "hello1");
//        webView.loadUrl("javascript:callJS()");
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:callJS()");
            }
        });
    }
    public void click(View view){
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:callJS()");
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
