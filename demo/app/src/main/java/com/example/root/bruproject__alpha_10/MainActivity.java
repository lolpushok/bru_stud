package com.example.root.bruproject__alpha_10;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv;
    String tablezn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button but=(Button)findViewById(R.id.button);
        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View e) {
        switch (e.getId()) {
            case R.id.button:
                Intent reiting = new Intent(this, Main2Activity.class);
                startActivity(reiting);
                break;
        }
    }
    }

