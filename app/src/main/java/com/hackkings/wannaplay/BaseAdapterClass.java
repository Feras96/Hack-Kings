package com.hackkings.wannaplay;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vlad on 12/10/2015.
 */


public class BaseAdapterClass extends BaseAdapter {

    private Activity activity;
    private ArrayList timestamp;
    private ArrayList sport;
    private ArrayList city;
    private ArrayList country;
    private ArrayList event_date;
    private ArrayList members;



    public BaseAdapterClass(Activity a,ArrayList timestamp,ArrayList sport, ArrayList city, ArrayList country, ArrayList event_date,ArrayList members)
    {
        this.activity = a;
        this.timestamp = timestamp;
        this.sport = sport;

        this.city = city;
        this.country = country;
        this.event_date = event_date;
        this.members = members;


System.out.println("APELATA");

    }
    @Override
    public int getCount() {
        if(timestamp==null) return 0;
        return timestamp.size();
    }

    @Override
    public Object getItem(int position) {
        if(timestamp==null) return null;
        return timestamp.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(convertView==null)
        {
            LayoutInflater inflater= activity.getLayoutInflater();
            v = inflater.inflate(R.layout.row_listitem,parent,false);
            System.out.println("CACAT");
        }


        System.out.println("AFISARE");

                TextView sport2 = (TextView) v.findViewById(R.id.sport);
                String sp = sport.get(position).toString();
                sport2.setText(sp);




        TextView date2 = (TextView) v.findViewById(R.id.date);
        String dt = event_date.get(position).toString();
        date2.setText(dt);



        TextView city2 = (TextView) v.findViewById(R.id.city);
        String ct = city.get(position).toString();
        city2.setText(ct);

        TextView country2 = (TextView) v.findViewById(R.id.country);
        String co = country.get(position).toString();
        country2.setText(co);

        TextView timestamp2 = (TextView) v.findViewById(R.id.times);
        String ts = timestamp.get(position).toString();
        timestamp2.setText(ts);

        TextView memb = (TextView) v.findViewById(R.id.mem);
        String mm =members.get(position).toString();
        memb.setText(mm);



        return v;
    }


}
