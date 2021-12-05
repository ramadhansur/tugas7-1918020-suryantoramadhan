package com.ramadhan.tugas7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private com.ramadhan.tugas7_sqlite.MyDatabase db;
    private EditText Enopol, Emerk, Etahun;
    private String Snopol, Smerk, Stahun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new com.ramadhan.tugas7_sqlite.MyDatabase(this);
        Enopol = (EditText) findViewById(R.id.create_nopol);
        Emerk = (EditText) findViewById(R.id.create_merk);
        Etahun = (EditText) findViewById(R.id.create_tahun);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snopol = String.valueOf(Enopol.getText());
                Smerk = String.valueOf(Emerk.getText());
                Stahun = String.valueOf(Etahun.getText());
                if (Snopol.equals("")){
                    Enopol.requestFocus();
                    Toast.makeText(MainCreate.this, "Isi Nopol terlebih dahulu",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Smerk.equals("")) {
                    Emerk.requestFocus();
                    Toast.makeText(MainCreate.this, "isi merk telebih dahulu",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stahun.equals("")) {
                    Etahun.requestFocus();
                    Toast.makeText(MainCreate.this, "isi tahun terlebih dahulu",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enopol.setText("");
                    Emerk.setText("");
                    Toast.makeText(MainCreate.this, "Mobil berhasi ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateJualBeliMobil(new JualBeliMobil(null, Snopol, Smerk, Stahun));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
