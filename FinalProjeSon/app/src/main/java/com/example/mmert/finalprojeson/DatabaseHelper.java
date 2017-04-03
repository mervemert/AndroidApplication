package com.example.mmert.finalprojeson;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mmert on 2.1.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //veritabanının ismini tanımlıyoruz.
    public static final String DATABASE_NAME = "UyeKaydi.db";
    public static final String TABLE_NAME = "kullanici";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //var olan bir database'e tablo eklemek istiyoruz
        db.execSQL("Create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ADI TEXT, SOYADI TEXT, KULLANICIADI STRING, SIFRE STRING, SIFRETKR STRING, EMAIL STRING)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }

    public boolean addNewRow(String adi, String soyadi, String kul_adi, String sifre, String sifre_tkr, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues(); //bu sınıf yardımıyla alanlara metotları doldurucaz
        values.put("ADI",adi); //hangi alana, hangi değer gelcek
        values.put("SOYADI",soyadi);
        values.put("KULLANICIADI",kul_adi);
        values.put("SIFRE",sifre);
        values.put("SIFRETKR",sifre_tkr);
        values.put("EMAIL",email);

        //kaydetmek için
        long result = db.insert(TABLE_NAME, null, values);
        if(result==-1)
            return false;
        else
            return true;


    }


}