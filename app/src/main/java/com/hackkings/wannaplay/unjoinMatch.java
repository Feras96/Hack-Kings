package com.hackkings.wannaplay;

/**
 * Created by vlad on 12/13/2015.
 */

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class unjoinMatch extends AsyncTask<String,Void,String> {


    private int byGetOrPost = 0;
    private String nume_tabel_date;
    String username;

//        public static String filename = "Vlad";
//        SharedPreferences data;
//        SharedPreferences.Editor editor;

    //flag 0 means get and 1 means post.(By default it is get.)
    public unjoinMatch(int flag) {
        byGetOrPost = flag;



    }

    protected void onPreExecute(){
        //   username = data.getString("usr","unknown");
//        Handler mHandler = new Handler();
//        upDialog.setMessage("Loading... Please wait");
//        upDialog.show();
//        super.onPreExecute();
//        mHandler.postDelayed(new Runnable()
//        {
//                        @Override
//                        public void run() {
//                                upDialog.dismiss();
//                        }
//        }, 1500);

    }
    @Override
    protected String doInBackground(String... arg0) {
        if(byGetOrPost == 1){ //means by Get Method



            try{

                String email = (String)arg0[0];
                String event_id   = (String)arg0[1];

                String link="http://www.webzard.com/databases/android/wannaplay/unjoin.php";
                String
                data = "&" + URLEncoder.encode("email", "UTF-8")
                        + "=" + URLEncoder.encode(email, "UTF-8");
                data += "&" + URLEncoder.encode("event_id", "UTF-8")
                        + "=" + URLEncoder.encode(event_id, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter
                        (conn.getOutputStream());
                wr.write( data );
                wr.flush();
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;
                // Read Server Response
                while((line = reader.readLine()) != null)
                {


                    sb.append(line);

                    break;
                }
                return sb.toString();
            }catch(Exception e){
                return //new String("Exception: " + e.getMessage());
                        new String("down");
            }
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result){
        //this.statusField.setText(result);

        if(result.toString().equals("succesfull"))
        {

//staField.setText(result);
        }
        if(result.toString().equals("failed"))
        {

            //         staField.setText(result);
        }

        if(result.toString().equals("down"))
        {
            // this.idField.setText("Our server is currently down");
        }
System.out.println(result);



//     if(result!="")
//     {
//     Intent intent = new Intent(context, Log_in.class);
//     context.startActivity(intent);
//     }
    }
//   protected void onPostExecute2(String sta)
//   {
//	   this.staField.setText(sta);
//   }
}