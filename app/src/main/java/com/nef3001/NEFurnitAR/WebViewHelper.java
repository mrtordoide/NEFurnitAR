package com.nef3001.NEFurnitAR;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.RenderPriority;
import android.widget.Toast;

public class WebViewHelper {

    private ProgressDialog mProgressDialog;

    //make it final so it will be accessible to setWebViewClient
    public WebView webview(final Context mContext) {

        // progress dialog
        mProgressDialog = new ProgressDialog(mContext);

        // new webview
        WebView web = new WebView(mContext);

        // web settings
        WebSettings webSettings = web.getSettings();

        // false
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setAppCacheEnabled(false);

        // true
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        // other
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setRenderPriority(RenderPriority.HIGH);

        web.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                //show the user progress percentage
                mProgressDialog.setMessage("Loading…" + progress + "%");
            }
        });

        web.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {

                //if there’s an error loading the page, make a toast
                Toast.makeText(mContext, description + '.', Toast.LENGTH_SHORT)
                        .show();

            }

            public void onPageFinished(WebView view, String url) {
                //after loading page, remove loading page
                mProgressDialog.dismiss();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                super.onPageStarted(view, url, favicon);

                //on page started, show loading page
                mProgressDialog.setCancelable(false);
                mProgressDialog.setMessage("Loading…");
                mProgressDialog.show();

            }

        });

        // return the web view
        return web;
    }
}