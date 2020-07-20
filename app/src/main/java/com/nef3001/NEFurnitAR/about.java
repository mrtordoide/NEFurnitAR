package com.nef3001.NEFurnitAR;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class about extends Activity {
    WebView web;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize our helper class
        // then call the webview() methods with our context as parameter (MainActivity.this)
        web = new WebViewHelper().webview(about.this);
        web.getSettings().setJavaScriptEnabled(true);
        // specify the url we want to load
        web.loadUrl("https://nefurnitar.tordoide.com/about");

        // you can add JavaScript interface like this:
        // web.addJavascriptInterface(new YourJsInterfaceClass(), “Android”);

        // set web as content view
        setContentView(web);

    }
}
