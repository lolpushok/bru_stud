package com.example.root.bruproject__alpha_10;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

   TableLayout tl;
    ArrayList<TextView> list=new ArrayList<TextView>();
    ArrayList<String> listzn=new ArrayList<String>();
    int rows=0;
    int collumns=0;
    String h1;
    TextView tx;
    String h2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        tl=(TableLayout)findViewById(R.id.tl);
        tx=(TextView)findViewById(R.id.textView);
        MyTask mt = new MyTask();
        mt.execute();
        while((rows==0)&&(collumns==0))
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int k=0;k<listzn.size();k++)
        {
            if (listzn.get(k).equals(" "))
            {
                listzn.set(k,"-");
            }
        }
        int count=0;
        for(int i=0;i<rows-2;i++)
        {
            TableRow rw=new TableRow(getApplicationContext());

            for(int j=0;j<collumns;j++)
            {   if(j!=0) {
                TextView a = new TextView(getApplicationContext());
                a.setText(listzn.get(count));
                a.setTextColor(0xff000000);
                a.setGravity(Gravity.CENTER_HORIZONTAL);
                a.setPadding(0, 0, 20, 0);
                rw.addView(a);
                count++;
            }
                else
            {
                TextView a = new TextView(getApplicationContext());
                a.setText(listzn.get(count));
                a.setTextColor(0xff000000);
                a.setPadding(0, 0, 20, 0);
                rw.addView(a);
                count++;
            }
            }
            tx.setText(h1+"\n"+h2);
            tx.setTextColor(0xff000000);
            tl.addView(rw);
        }
    }
    class MyTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            Document doc = null;
            try {
                doc = Jsoup.connect("http://vuz2.bru.by/rate/10024023/").get();
            } catch (IOException e) {
                //Если не получилось считать
                e.printStackTrace();
            }
            if (doc!=null) {
                Elements el = doc.select("table");
                Elements eltr=el.select("tr");
                h1=eltr.first().text();
                el=el.select("td");
                int i;
                Elements h2e=doc.select("h2");
                h2=h2e.first().text();
                i=eltr.get(1).select("th").size();
                collumns=i;
                rows=eltr.size();
                Elements el2=doc.select("tr");
                el2=el2.get(1).select("th");
                for (int k=0;k<el2.size();k++) {
                    listzn.add(el2.get(k).text() + " ");
                }
                    for (int k=listzn.size();k<el.size();k++) {
                            listzn.add(el.get(k).text() + " ");
                    }
                    }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }


}
