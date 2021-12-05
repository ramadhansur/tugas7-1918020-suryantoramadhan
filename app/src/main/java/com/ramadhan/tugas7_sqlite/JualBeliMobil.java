package com.ramadhan.tugas7_sqlite;

public class JualBeliMobil
{ private String _id, _nopol, _merk, _tahun;
    public JualBeliMobil(String id, String nopol, String merk, String tahun) {
        this._id = id;
        this._nopol = nopol;
        this._merk = merk;
        this._tahun = tahun;
    }
    public JualBeliMobil() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nopol() {
        return _nopol;
    }
    public void set_nopol(String _nopol) {
        this._nopol = _nopol;
    }
    public String get_merk() {
        return _merk;
    }
    public void set_merk(String _merk) {
        this._merk = _merk;
    }
    public String get_tahun() {

        return _tahun;
    }
    public void set_tahun(String _tahun) {
        this._tahun = _tahun;
    }
}

