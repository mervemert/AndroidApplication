package com.example.mmert.finalprojeson;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UyeActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    private Button btnekle;
    private EditText edtadi, edtsoyadi, edtkuladi, edtsifre, edtsifretkr, edtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        myDb = new DatabaseHelper(this);
        addEkleListener();
    }

 public void addEkleListener() {
    btnekle = (Button)findViewById(R.id.btn_kaydet);
    edtadi = (EditText)findViewById(R.id.edt_adi);
    edtsoyadi = (EditText)findViewById(R.id.edt_soyadi);
    edtkuladi = (EditText)findViewById(R.id.edt_kuladi);
    edtsifre = (EditText)findViewById(R.id.edt_sifre);
    edtsifretkr = (EditText)findViewById(R.id.edt_sifretkr);
    edtemail = (EditText)findViewById(R.id.edt_email);

    btnekle.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent uye_intent = new Intent(UyeActivity.this, GirisActivity.class);
                    startActivity(uye_intent);
                    boolean sonuc = myDb.addNewRow(edtadi.getText().toString(),edtsoyadi.getText().toString(),
                            edtkuladi.getText().toString(),edtsifre.getText().toString(),edtsifretkr.getText().toString(),
                            edtemail.getText().toString());

                    if (edtsifre.getText().toString().equals(edtsifretkr.getText().toString()))
                    {

                        if(sonuc)
                            Toast.makeText(UyeActivity.this, "Kayıt Eklendi", Toast.LENGTH_SHORT).show();
                    }

                    else
                            Toast.makeText(UyeActivity.this, "Kayıt Eklenemedi", Toast.LENGTH_SHORT).show();

                }

            }
    );
}
}
