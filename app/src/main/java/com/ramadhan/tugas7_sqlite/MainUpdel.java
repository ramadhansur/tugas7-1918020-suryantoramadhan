package com.ramadhan.tugas7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snopol, Smerk, Stahun;
    private EditText Enopol, Emerk, Etahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snopol = i.getStringExtra("Inopol");
        Smerk = i.getStringExtra("Imerk");
        Stahun = i.getStringExtra("Itahun");
        Enopol = (EditText) findViewById(R.id.updel_nopol);
        Emerk = (EditText) findViewById(R.id.updel_merk);
        Etahun = (EditText) findViewById(R.id.updel_tahun);
        Enopol.setText(Snopol);
        Emerk.setText(Smerk);
        Etahun.setText(Stahun);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snopol = String.valueOf(Enopol.getText());
                Smerk = String.valueOf(Emerk.getText());
                if (Snopol.equals("")){
                    Enopol.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nopol",
                            Toast.LENGTH_SHORT).show();
                } else if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi merk",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tahun",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateJualBeliMobil(new JualBeliMobil(Sid, Snopol, Smerk, Stahun));
                    Toast.makeText(MainUpdel.this, "Mobil telah diubah",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteJualBeliMobil(new JualBeliMobil(Sid, Snopol, Smerk, Stahun));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
