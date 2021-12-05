package com.ramadhan.tugas7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void create(View view){
        Intent a = new Intent(MainActivity.this, com.ramadhan.tugas7_sqlite.MainCreate.class);
        startActivity(a);
    }
    public void read(View view){
        Intent b = new Intent(MainActivity.this, com.ramadhan.tugas7_sqlite.MainRead.class);
        startActivity(b);
    }
}