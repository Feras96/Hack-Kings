package com.hackkings.wannaplay;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.widget.ListView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vlad on 12/10/2015.
 */
public class getEvent extends FragmentActivity{

    ArrayList<String> timestamp = new ArrayList<String>();
    ArrayList<String> sport = new ArrayList<String>();


    ArrayList<String> city = new ArrayList<String>();
    ArrayList<String> country = new ArrayList<String>();
    ArrayList<String> event_date = new ArrayList<String>();
    ArrayList<String> members = new ArrayList<String>();


    ListView liste;
    BaseAdapterClass adapter;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste = (ListView) findViewById(R.id.listView1);
//        init();
//        outputLine("Request started...");
        new getData().execute("http://webzard.com/databases/android/com.hackkings.wannaplay/getevents.php");




    }

    private class getData extends AsyncTask<String,Double,JSONArray> {

        @Override
        protected  JSONArray doInBackground(String... params) {

            if(params.length!=1) return null;

            try{
                URL url = new URL(params[0]);
                InputStream inStream = url.openStream();
                DataInputStream dataInStream = new DataInputStream(inStream);

                byte[] buffer = new byte[1024];
                int bufferLength;

                ByteArrayOutputStream output  = new ByteArrayOutputStream();

                while((bufferLength = dataInStream.read(buffer))>0)
                {
                    output.write(buffer,0,bufferLength);
                }
                //   outputLine("Success1!");
                return new JSONArray(output.toString("UTF-8"));

            }catch (Exception e){

                //   outputLine("Something went wrong1!");
                return null;
            }
        }

        protected void onPostExecute(JSONArray result)
        {
            if(result ==null ) return;
            try {
                JSONArray list = result.getJSONArray(0);
                JSONObject l;
                for(int i= list.length()-1;i>=0;i--)
                {
                    l = list.getJSONObject(i);

                    timestamp.add("Posted on: "+l.getString("timestamp"));
                    sport.add(l.getString("sport"));

                    city.add("Location: "+l.getString("city")+",");
                    country.add(l.getString("country"));
                    event_date.add("Available: "+l.getString("event_date"));
                    members.add("Players: "+l.getString("members"));


//System.out.println("!!");
                    //    outputLine(l.getString("timestamp"));
                    //    outputLine("Success2!");

                }
                adapter = new BaseAdapterClass(getEvent.this,timestamp,sport,city,country,event_date,members);
                liste.setAdapter(adapter);

            }catch (Exception e)
            {
                //    outputLine("Something went wrong2!");
            }
        }
    }
    protected void init() {
        outputView = (TextView) findViewById(R.id.output);
    }
    private TextView outputView;
    private String output = "";
    protected void outputLine(String s) {
        output += (new DateTime()).toString("HH:mm:ss") + " <strong>" + s + "</strong><br />";
        outputView.setText(Html.fromHtml(output));
    }



}
