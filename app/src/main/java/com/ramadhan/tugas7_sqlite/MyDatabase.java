package com.ramadhan.tugas7_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_JualBeliMobil";
    private static final String tb_jualbelimobil = "tb_jualbelimobil";
    private static final String tb_jualbelimobil_id = "id";
    private static final String tb_jualbelimobil_nopol = "nopol";
    private static final String tb_jualbelimobil_merk = "merk";
    private static final String tb_jualbelimobil_tahun = "tahun";
    private static final String CREATE_TABLE_JUALBELIMOBIL = "CREATE TABLE " + tb_jualbelimobil +"("
            + tb_jualbelimobil_id + " INTEGER PRIMARY KEY ,"
            + tb_jualbelimobil_nopol + " TEXT ,"
            + tb_jualbelimobil_merk + " TEXT ,"
            + tb_jualbelimobil_tahun +" TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_JUALBELIMOBIL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateJualBeliMobil(JualBeliMobil data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_jualbelimobil_id, data.get_id());
        values.put(tb_jualbelimobil_nopol, data.get_nopol());
        values.put(tb_jualbelimobil_merk, data.get_merk());
        values.put(tb_jualbelimobil_tahun, data.get_tahun());
        db.insert(tb_jualbelimobil, null, values);
        db.close();
    }
    public List<JualBeliMobil> ReadJualBeliMobil() {
        List<JualBeliMobil> listMbl = new ArrayList<JualBeliMobil>();
        String selectQuery = "SELECT * FROM " + tb_jualbelimobil;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                JualBeliMobil data = new JualBeliMobil();
                data.set_id(cursor.getString(0));
                data.set_nopol(cursor.getString(1));
                data.set_merk(cursor.getString(2));
                data.set_tahun(cursor.getString(3));
                listMbl.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMbl;
    }
    public int UpdateJualBeliMobil (JualBeliMobil data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_jualbelimobil_nopol, data.get_nopol());
        values.put(tb_jualbelimobil_merk, data.get_merk());
        values.put(tb_jualbelimobil_tahun, data.get_tahun());
        return db.update(tb_jualbelimobil, values, tb_jualbelimobil_id + " = ?", new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteJualBeliMobil(JualBeliMobil data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_jualbelimobil,tb_jualbelimobil_id+ " = ?", new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
