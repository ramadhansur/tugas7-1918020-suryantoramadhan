package com.ramadhan.tugas7_sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<JualBeliMobil> JualBeliMobil;
    public CustomListAdapter(Activity activity, List<JualBeliMobil> JualBeliMobil) {
        this.activity = activity;
        this.JualBeliMobil = JualBeliMobil;
    }
    @Override
    public int getCount() {
        return JualBeliMobil.size();
    }
    @Override
    public Object getItem(int location) {
        return JualBeliMobil.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nopol);
        TextView jenis = (TextView)
                convertView.findViewById(R.id.text_merk);
        TextView asal = (TextView)
                convertView.findViewById(R.id.text_tahun);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        JualBeliMobil j = JualBeliMobil.get(position);
        nama.setText("NOPOL : "+ j.get_nopol());
        jenis.setText("Merk : "+ j.get_merk());
        asal.setText("Tahun : "+ j.get_tahun());
        return convertView;
    }
}

