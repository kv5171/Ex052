package com.example.ex052;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText url;
    WebView wV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = (EditText) findViewById(R.id.url);
        wV = (WebView) findViewById(R.id.wV);

        wV.getSettings().setJavaScriptEnabled(true);
        wV.setWebViewClient(new MyWebViewClient());
    }

    public void showUrl(View view) {
        String urlLink = url.getText().toString();

        // Good url is a url that includes http or https, if you enter:
        // ynet.co.il it isnt good because it is not includes one of them... (needs - https://ynet.co.il)
        // (The search engine do the move between a url like this and a http/https link - its not us now...)
        if ((!urlLink.contains("http")) && (!urlLink.contains("https")))
        {
            Toast.makeText(this, "Invalid Url", Toast.LENGTH_SHORT).show();
        }
        else {
        wV.loadUrl(urlLink);
        }
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}