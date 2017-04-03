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
import android.widget.TextView;

public class EgimActivity extends AppCompatActivity {
   Button btnHeyelan, btnRisk;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egim);
        btnHeyelan = (Button)findViewById(R.id.btn_egimHesapla);
        btnRisk = (Button)findViewById(R.id.btn_heyelan);
        final EditText edtYuk = (EditText)findViewById(R.id.edt_yukseklik);
        final EditText edtUzak = (EditText)findViewById(R.id.edt_yatay);
        final TextView sonuc = (TextView)findViewById(R.id.txt_sonuc);
        btnRisk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent heyelan_intent = new Intent(EgimActivity.this,HeyelanRisk.class); //geldiğimiz acvitiy ve hedef activity
                        heyelan_intent.putExtra("veri",sonuc.getText().toString());
                        startActivity(heyelan_intent);
                    }
                }
        );

        btnHeyelan.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        double edtYukdouble = Double.parseDouble(edtYuk.getText().toString());
                        double edtUzakdouble = Double.parseDouble(edtUzak.getText().toString());
                        sonuc.setText(String.valueOf((double)edtYukdouble / edtUzakdouble * 100.0));
                    }
                }
        );
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
    }

}
