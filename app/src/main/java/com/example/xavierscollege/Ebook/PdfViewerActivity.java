package com.example.xavierscollege.Ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.xavierscollege.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class PdfViewerActivity extends AppCompatActivity {
    private String url;
    private WebView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);


        pdfView = findViewById(R.id.pdfView);
        pdfView.getSettings().setJavaScriptEnabled(true);

        url = getIntent().getStringExtra("pdfUrl");

        pdfView.setWebViewClient(new WebViewClient(){
           /* @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url
                nished(view, url);
            }*/

        });

        String fileurl= " ";
        try{
            fileurl = URLEncoder.encode(url,"UTF-8");
        }catch (Exception e)
        {

        }

        pdfView.loadUrl("http://docs.google.com/gview?embedded=true&url="+fileurl);





    }

}