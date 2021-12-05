package com.ramadhan.tugas7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<JualBeliMobil> listJualBeliMobil = new ArrayList<JualBeliMobil>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listJualBeliMobil);
        mListView = (ListView) findViewById(R.id.list_mobil);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listJualBeliMobil.clear();
        List<JualBeliMobil> JualBeliMobil = db.ReadJualBeliMobil();
        for (JualBeliMobil jual :JualBeliMobil) {
            JualBeliMobil mobil = new JualBeliMobil();
            mobil.set_id(jual.get_id());
            mobil.set_nopol(jual.get_nopol());
            mobil.set_merk(jual.get_merk());
            mobil.set_tahun(jual.get_tahun());
            listJualBeliMobil.add(mobil);
            if ((listJualBeliMobil.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        JualBeliMobil detailmobil = (JualBeliMobil) o;
        String Sid = detailmobil.get_id();
        String Snopol = detailmobil.get_nopol();
        String Smerk = detailmobil.get_merk();
        String Stahun = detailmobil.get_tahun();
        Intent goUpdel = new Intent(MainRead.this, com.ramadhan.tugas7_sqlite.MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inopol", Snopol);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Itahun", Stahun);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listJualBeliMobil.clear();
        mListView.setAdapter(adapter_off);
        List<JualBeliMobil> jualbelimobil = db.ReadJualBeliMobil();
        for (JualBeliMobil jbm : jualbelimobil) {
            JualBeliMobil jual = new JualBeliMobil();
            jual.set_id(jbm.get_id());
            jual.set_nopol(jbm.get_nopol());
            jual.set_merk(jbm.get_merk());
            jual.set_tahun(jbm.get_tahun());
            listJualBeliMobil.add(jual);
            if ((listJualBeliMobil.isEmpty()))
                Toast.makeText(MainRead.this, "Data Kosong",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

}

