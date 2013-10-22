package com.ling.helloworld;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	WebView wv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        wv = (WebView) findViewById(R.id.wv);
        wv.loadUrl("http://www.mit.edu");
        wv.setWebViewClient(new WebViewClientListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private class WebViewClientListener extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            wv.loadUrl(url);
            return true;
        }
    }
    
//    public boolean onKeyDown(int keyCoder,KeyEvent event){  
//        if(wv.canGoBack() && keyCoder == KeyEvent.KEYCODE_BACK){  
//        	wv.goBack();    
//            return true;  
//         }  
//        return super.onKeyDown(keyCoder, event);
//        }  
    

    public void btnBackwardClicked(View source){
      if(wv.canGoBack()){  
    	wv.goBack();     
     }  
    }
    
    public void btnForwardClicked(View source){
        if(wv.canGoForward()){  
        	wv.goForward();     
         }  
    }
    
    public void btnRefreshClicked(View source){
    	wv.reload();
    }
}
