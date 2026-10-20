package com.headshotrecoil.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebChromeClient;
import android.view.View;
public class MainActivity extends Activity {
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setStatusBarColor(android.graphics.Color.rgb(9,11,18));
    getWindow().setNavigationBarColor(android.graphics.Color.rgb(9,11,18));
    WebView web = new WebView(this);
    web.setBackgroundColor(android.graphics.Color.rgb(9,11,18));
    web.getSettings().setJavaScriptEnabled(true);
    web.getSettings().setDomStorageEnabled(true);
    web.setWebViewClient(new WebViewClient(){
      @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("https://t.me/")) {
          try { startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url))); }
          catch(Exception ignored) {}
          return true;
        }
        return false;
      }
    });
    web.loadUrl("file:///android_asset/index.html");
    setContentView(web);
  }
}